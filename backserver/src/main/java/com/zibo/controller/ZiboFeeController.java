package com.zibo.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zibo.entity.SampleData;
import com.zibo.entity.ZiboFee;
import com.zibo.repository.SampleDataRepository;
import com.zibo.repository.ZiboFeeRepository;
import com.zibo.request.SampleBatchOperation;
import com.zibo.response.BaseResponse;
import com.zibo.response.PageResponse;
import com.zibo.response.SuccessResponse;
import com.zibo.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaoxiong.zhan
 */
@RestController
@RequestMapping("/api/fee")
public class ZiboFeeController extends BaseController {
    @Autowired
    private ZiboFeeRepository ziboFeeRepo;

    @Autowired
    private SampleDataRepository sampleDataRepository;

    @PostMapping
    public BaseResponse create(@RequestBody ZiboFee fee) {
        if (fee.getId() != null) {
            ZiboFee old = ziboFeeRepo.findById(fee.getId()).orElse(fee);
            EntityUtils.copyProperties(old, fee);
        }
        return new SuccessResponse<>(ziboFeeRepo.save(fee));
    }

    @GetMapping
    public BaseResponse list(@PageableDefault Pageable pageable,
                             @RequestParam(required = false) String searchCondition,
                             @RequestParam(required = false) Boolean audit) {
        List<ZiboFee> feeList = Lists.newArrayList(ziboFeeRepo.findAll());
        if (!Strings.isNullOrEmpty(searchCondition)) {
            feeList = feeList.stream().filter(fee -> fee.toString().contains(searchCondition))
                    .collect(Collectors.toList());
        }
        if (audit != null) {
            feeList = feeList.stream().filter(fee -> fee.isAudit() == audit)
                    .collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(feeList, pageable));
    }

    @PutMapping("{id}/verify")
    public BaseResponse verify(@PathVariable Long id) {
        ZiboFee ziboFee = ziboFeeRepo.findById(id).orElseThrow(RuntimeException::new);
        ziboFee.setAudit(true);
        ziboFee.setAuditTime(new Timestamp(System.currentTimeMillis()));
        return new SuccessResponse<>(ziboFeeRepo.save(ziboFee));
    }

    @PutMapping("{id}/cancel_verify")
    public BaseResponse cancelVerify(@PathVariable Long id) {
        ZiboFee ziboFee = ziboFeeRepo.findById(id).orElseThrow(RuntimeException::new);
        ziboFee.setAudit(false);
        return new SuccessResponse<>(ziboFeeRepo.save(ziboFee));
    }

    @PutMapping("verify")
    public BaseResponse verifyAll(@RequestBody SampleBatchOperation batchOperation) {
        List<ZiboFee> feeList = Lists.newArrayList(ziboFeeRepo.findAllById(Arrays.asList(batchOperation.getId())));
        for (ZiboFee fee : feeList) {
            fee.setAudit(true);
        }
        return new SuccessResponse<>(ziboFeeRepo.saveAll(feeList));
    }

    @PutMapping("cancel_verify")
    public BaseResponse cancelVerifyAll(@RequestBody SampleBatchOperation batchOperation) {
        List<ZiboFee> feeList = Lists.newArrayList(ziboFeeRepo.findAllById(Arrays.asList(batchOperation.getId())));
        for (ZiboFee fee : feeList) {
            fee.setAudit(false);
        }
        return new SuccessResponse<>(ziboFeeRepo.saveAll(feeList));
    }

    @GetMapping("{id}")
    public BaseResponse getOne(@PathVariable Long id) {
        ZiboFee ziboFee = ziboFeeRepo.findById(id).orElseThrow(RuntimeException::new);
        return new SuccessResponse<>(ziboFee);
    }

    @DeleteMapping()
    public BaseResponse deleteAll(@RequestBody SampleBatchOperation batchOperation) {
        List<ZiboFee> feeList = Lists.newArrayList(ziboFeeRepo.findAllById(Arrays.asList(batchOperation.getId())));
        ziboFeeRepo.deleteAll(feeList);
        return new SuccessResponse<>("");
    }

    @PutMapping("/{feeId}/relate")
    public BaseResponse relateSamples(@PathVariable Long feeId,
                                      @RequestBody SampleBatchOperation batchOperation) {
        ZiboFee ziboFee = ziboFeeRepo.findById(feeId).orElseThrow(RuntimeException::new);
        List<SampleData> data = sampleDataRepository.findAllByIdIn(batchOperation.getSampleIds());
        ziboFee.setSamples(data);
        ziboFeeRepo.save(ziboFee);
        return new SuccessResponse<>(ziboFee);
    }

    @PutMapping("/{feeId}/cancel_relate")
    public BaseResponse cancelRelateSamples(@PathVariable Long feeId,
                                            @RequestBody SampleBatchOperation batchOperation) {
        ZiboFee ziboFee = ziboFeeRepo.findById(feeId).orElseThrow(RuntimeException::new);
        List<SampleData> data = sampleDataRepository.findAllByIdIn(batchOperation.getSampleIds());
        ziboFee.getSamples().removeAll(data);
        ziboFeeRepo.save(ziboFee);
        return new SuccessResponse<>(ziboFee);
    }

    @GetMapping("/{feeId}/relate")
    public BaseResponse relateSampleInfo(
            @PageableDefault(size = Integer.MAX_VALUE) Pageable pageable,
            @PathVariable Long feeId,
            @RequestParam(required = false) String searchCondition) {
        ZiboFee ziboFee = ziboFeeRepo.findById(feeId).orElseThrow(RuntimeException::new);
        List<SampleData> samples = ziboFee.getSamples();
        if (!Strings.isNullOrEmpty(searchCondition)) {
            samples = samples.stream().filter(sampleData -> sampleData.toString()
                    .contains(searchCondition))
                    .collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(samples, pageable));
    }

    @GetMapping("/relate")
    public BaseResponse relateSamples(
            @PageableDefault(size = Integer.MAX_VALUE) Pageable pageable,
            @RequestParam(required = false) String searchCondition) {
        List<ZiboFee> feeList = Lists.newArrayList(ziboFeeRepo.findAll());
        List<SampleData> samples = Lists.newArrayList();
        for (ZiboFee fee : feeList) {
            List<SampleData> tmp = fee.getSamples();
            if (!Strings.isNullOrEmpty(searchCondition)) {
                tmp = tmp.stream().filter(sampleData -> sampleData.toString()
                        .contains(searchCondition))
                        .collect(Collectors.toList());
            }
            samples.addAll(tmp);
        }
        return new SuccessResponse<>(PageResponse.build(samples, pageable));
    }
}
