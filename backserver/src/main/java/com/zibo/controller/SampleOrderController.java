package com.zibo.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zibo.entity.SampleOrder;
import com.zibo.repository.SampleOrderRepository;
import com.zibo.request.SampleBatchOperation;
import com.zibo.response.BaseResponse;
import com.zibo.response.PageResponse;
import com.zibo.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaoxiong.zhan
 */
@RestController
@RequestMapping("/api/sample_order")
public class SampleOrderController extends BaseController {
    @Autowired
    private SampleOrderRepository sampleOrderRepo;

    @PostMapping
    public BaseResponse create(@RequestBody SampleOrder sampleOrder) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sampleOrder.getSampleName()), "样品名称不能为空。");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(sampleOrder.getSampleNo()), "样品编号不能为空。");
        return new SuccessResponse<>(sampleOrderRepo.save(sampleOrder));
    }

    @GetMapping
    public BaseResponse list(@PageableDefault Pageable pageable, @RequestParam(required = false) String searchCondition) {
        List<SampleOrder> list = Lists.newArrayList(sampleOrderRepo.findAll()).stream().filter(t -> !t.isDeleted()).collect(Collectors
                .toList());
        if (!Strings.isNullOrEmpty(searchCondition)) {
            list = list.stream().filter(sampleOrder -> sampleOrder.toString().contains(searchCondition)).collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(list, pageable));
    }

    @GetMapping("/{id}")
    public BaseResponse getOne(@PathVariable Long id) {
        return new SuccessResponse<>(sampleOrderRepo.findById(id));
    }

    @DeleteMapping
    public BaseResponse deleteAll(@RequestBody SampleBatchOperation sampleBatchOperation) {
        List<SampleOrder> list = sampleOrderRepo.findAllByIdIn(sampleBatchOperation.getId());
        for (SampleOrder order : list) {
            order.setDeleted(true);
        }
        sampleOrderRepo.saveAll(list);
        return new SuccessResponse("");
    }
}
