package com.zibo.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.zibo.entity.EnterpriseInfo;
import com.zibo.response.BaseResponse;
import com.zibo.response.SuccessResponse;
import com.zibo.service.EnterpriseService;
import com.zibo.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/enterprises")
public class EnterpriseController extends BaseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping
    public BaseResponse create(@RequestBody EnterpriseInfo enterpriseInfo) {
        return new SuccessResponse<>(enterpriseService.saveOrUpdate(enterpriseInfo));
    }

    @PutMapping("/{id}")
    public BaseResponse update(@PathVariable Long id,
                               @RequestBody EnterpriseInfo enterpriseInfo) {
        EnterpriseInfo old = enterpriseService.getById(id);
        Preconditions.checkNotNull(old, "不存在的企业。");
        EntityUtils.copyProperties(enterpriseInfo, old);
        return new SuccessResponse<>(enterpriseService.saveOrUpdate(old));
    }

    @GetMapping
    public BaseResponse list(@RequestParam(required = false) String keyWord) {
        List<EnterpriseInfo> enterpriseInfos = enterpriseService.getList();
        if (!Strings.isNullOrEmpty(keyWord)) {
            enterpriseInfos = enterpriseInfos.stream()
                    .filter(enterpriseInfo -> enterpriseInfo.toString().contains(keyWord))
                    .collect(Collectors.toList());
        }
        return new SuccessResponse<>(enterpriseInfos);
    }

    @GetMapping("/{id}")
    public BaseResponse getOne(@PathVariable Long id) {
        EnterpriseInfo enterpriseInfo = enterpriseService.getById(id);
        return new SuccessResponse<>(enterpriseInfo);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteOne(@PathVariable Long id) {
        EnterpriseInfo enterpriseInfo = enterpriseService.getById(id);
        enterpriseService.delete(enterpriseInfo);
        return new SuccessResponse<>("");
    }
}
