package com.zibo.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zibo.entity.Department;
import com.zibo.repository.DepartmentRepository;
import com.zibo.response.BaseResponse;
import com.zibo.response.PageResponse;
import com.zibo.response.SuccessResponse;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaoxiong.zhan
 */
@RestController
@RequestMapping("/api/dept")
public class DepartmentController extends BaseController {
    @Autowired
    private DepartmentRepository deptRepo;

    @PostMapping
    public BaseResponse create(@RequestBody Department department) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(department.getDeptName()), "部门名称不能为空。");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(department.getDeptAbbr()), "部门缩写不能为空。");
        return new SuccessResponse<>(deptRepo.save(department));
    }

    @GetMapping
    public BaseResponse list(@PageableDefault(size = Integer.MAX_VALUE) Pageable pageable, @RequestParam(required = false) String keyWord) {
        List<Department> allList = Lists.newArrayList(deptRepo.findAll());
        if (!Strings.isNullOrEmpty(keyWord)) {
            allList = allList.stream().filter(department -> department.toString().contains(keyWord)).collect(Collectors.toList());
        }
        return new SuccessResponse<>(PageResponse.build(allList, pageable));
    }

    @GetMapping("/{id}")
    public BaseResponse getOne(@PathVariable Long id) {
        return new SuccessResponse<>(deptRepo.findById(id).orElse(null));
    }
}
