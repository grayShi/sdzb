package com.zibo.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zibo.constants.DictType;
import com.zibo.entity.GlobalDict;
import com.zibo.repository.DictRepository;
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaoxiong.zhan
 */
@RestController
@RequestMapping("/api/dict")
public class DictController {
    @Autowired
    private DictRepository dictRepository;

    @PostMapping("/{type}")
    public BaseResponse create(@PathVariable DictType type, @RequestBody GlobalDict dict) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(dict.getDetail()), "内容不能为空。");
        if (dict.getId() != null) {
            GlobalDict old = dictRepository.findById(dict.getId()).orElse(dict);
            old.setDetail(dict.getDetail());
            old.setDict(dict.getDict());
        }
        dict.setType(type);
        return new SuccessResponse<>(dictRepository.save(dict));
    }

    @GetMapping("/{id}")
    public BaseResponse getOne(@PathVariable Long id) {
        return new SuccessResponse<>(dictRepository.findById(id));
    }

    @GetMapping("/list/{type}")
    public BaseResponse list(@PathVariable DictType type,
                             @PageableDefault Pageable pageable,
                             @RequestParam(required = false) String searchCondition) {
        List<GlobalDict> dicts = dictRepository.findAllByType(type);
        if (!Strings.isNullOrEmpty(searchCondition)) {
            dicts = dicts.stream().filter(globalDict -> globalDict.toString()
                    .contains(searchCondition)).collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(dicts, pageable));
    }

    @DeleteMapping("/{id}")
    public BaseResponse delete(@PathVariable Long id) {
        dictRepository.deleteById(id);
        return new SuccessResponse<>("");
    }

    @DeleteMapping
    public BaseResponse deleteAll(@RequestBody SampleBatchOperation batchOperation) {
        List<GlobalDict> globalDicts = Lists.newArrayList(dictRepository.findAllById(Arrays.asList(batchOperation.getId())));
        dictRepository.deleteAll(globalDicts);
        return new SuccessResponse<>("");
    }
}
