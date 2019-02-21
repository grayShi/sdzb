package com.zibo.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zibo.constants.SampleStatus;
import com.zibo.entity.SampleProduct;
import com.zibo.entity.SampleProductRecord;
import com.zibo.repository.SampleProductRecordRepository;
import com.zibo.repository.SampleProductRepository;
import com.zibo.request.SampleProductInStoreRequest;
import com.zibo.response.BaseResponse;
import com.zibo.response.ErrorResponse;
import com.zibo.response.PageResponse;
import com.zibo.response.SuccessResponse;
import com.zibo.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaoxiong.zhan
 */
@RestController
@RequestMapping("api/sample_product")
public class SampleProductController extends BaseController {
    @Autowired
    private SampleProductRepository sampleProductRepo;

    @Autowired
    private SampleProductRecordRepository sampleProductRecordRepo;

    @GetMapping
    public BaseResponse list(@PageableDefault Pageable pageable, @RequestParam(required = false) String searchCondition) {
        List<SampleProduct> productList = Lists.newArrayList(sampleProductRepo.findAll());
        if (!Strings.isNullOrEmpty(searchCondition)) {
            productList = productList.stream().filter(sampleProduct -> sampleProduct.toString().contains(searchCondition)).collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(productList, pageable));
    }

    @GetMapping("{productId}/{type}/list")
    public BaseResponse listByType(@PageableDefault Pageable pageable,
                                   @RequestParam(required = false) String searchCondition,
                                   @PathVariable String productId,
                                   @PathVariable SampleProductRecord.OpType type) {
        List<SampleProductRecord> records = Lists.newArrayList(sampleProductRecordRepo.findAllBySampleProductIdAndOpType(productId, type));
        if (!Strings.isNullOrEmpty(searchCondition)) {
            records = records.stream().filter(record -> record.toString().contains(searchCondition)).collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(records, pageable));
    }

    @PostMapping("{id}/in_store")
    public BaseResponse inStore(@PathVariable Long id,
                                @RequestBody SampleProductInStoreRequest request) {
        SampleProduct sampleProduct = sampleProductRepo.findById(id).get();
        SampleProductRecord record = new SampleProductRecord();
        record.setSampleProductId(sampleProduct.getProductId());
        record.setOpCount(request.getInStoreCount());
        record.setOpPlace(request.getInStorePlace());
        record.setOpDate(DateUtil.YYYY_MM_DD.format(new Date()));
        record.setOpType(SampleProductRecord.OpType.in_store);
        sampleProductRecordRepo.save(record);
        sampleProduct.setSampleCount(sampleProduct.getSampleCount() + request.getInStoreCount());
        sampleProductRepo.save(sampleProduct);
        return new SuccessResponse<>();
    }

    @PostMapping("{id}/operate")
    public BaseResponse operate(@PathVariable Long id,
                                @RequestBody SampleProductRecord record) {
        Preconditions.checkNotNull(record.getOpCount(), "操作数量不能为空。");
        SampleProduct sampleProduct = sampleProductRepo.findById(id).get();
        switch (record.getOpType()) {
            case get:
                if (sampleProduct.getSampleCount() < record.getOpCount()) {
                    return new ErrorResponse("样品数量不足。");
                }
                sampleProduct.setSampleCount(sampleProduct.getSampleCount() - record.getOpCount());
                break;
            case take:
                sampleProduct.setSampleCount(0);
                sampleProduct.setStatus(SampleStatus.fetched);
                break;
            case in_store:
            case withdraw:
                sampleProduct.setSampleCount(sampleProduct.getSampleCount() + record.getOpCount());
                break;
            default:
                break;
        }
        record.setSampleProductId(sampleProduct.getProductId());
        sampleProductRecordRepo.save(record);
        sampleProductRepo.save(sampleProduct);
        return new SuccessResponse<>();
    }
}
