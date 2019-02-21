package com.zibo.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zibo.entity.ZiboTable;
import com.zibo.repository.ZiboTableRepository;
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
@RequestMapping("/api/zibo_table")
public class ZiboTableController extends BaseController {
    @Autowired
    private ZiboTableRepository ziboTableRepo;

    @PostMapping
    public BaseResponse create(@RequestBody ZiboTable ziboTable) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(ziboTable.getTableName()), "表格名称不能为空。");
        return new SuccessResponse<>(ziboTableRepo.save(ziboTable));
    }

    @GetMapping
    public BaseResponse list(@PageableDefault Pageable pageable, @RequestParam(required = false) String searchCondition) {
        List<ZiboTable> list = Lists.newArrayList(ziboTableRepo.findAll());
        if (!Strings.isNullOrEmpty(searchCondition)) {
            list = list.stream().filter(ziboTable -> ziboTable.toString().contains(searchCondition)).collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(list, pageable));
    }

    @GetMapping("/{id}")
    public BaseResponse getOne(@PathVariable Long id) {
        return new SuccessResponse<>(ziboTableRepo.findById(id));
    }

    @DeleteMapping
    public BaseResponse deleteAll(@RequestBody SampleBatchOperation sampleBatchOperation) {
        List<ZiboTable> data = ziboTableRepo.findAllByIdIn(sampleBatchOperation.getId());
        for (ZiboTable s : data) {
            s.setDeleted(true);
        }
        ziboTableRepo.saveAll(data);
        return new SuccessResponse("");
    }
}
