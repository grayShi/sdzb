package com.zibo.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zibo.entity.EnterpriseInfo;
import com.zibo.entity.SampleData;
import com.zibo.entity.SampleProduct;
import com.zibo.repository.CheckProjectRepository;
import com.zibo.repository.EnterpriseRepository;
import com.zibo.repository.SampleDataRepository;
import com.zibo.repository.SampleProductRepository;
import com.zibo.request.SampleBatchOperation;
import com.zibo.request.SampleModel;
import com.zibo.request.SampleOrderRequest;
import com.zibo.request.SampleReworkRequest;
import com.zibo.response.BaseResponse;
import com.zibo.response.PageResponse;
import com.zibo.response.SuccessResponse;
import com.zibo.service.SampleService;
import com.zibo.utils.EntityUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaoxiong.zhan
 */
@RestController
@RequestMapping("/api/sample")
public class SampleController extends BaseController {
    @Autowired
    private SampleService sampleService;

    @Autowired
    private SampleProductRepository sampleProductRepo;

    @Autowired
    private EnterpriseRepository enterpriseRepo;

    @Autowired
    private CheckProjectRepository checkProjectRepo;

    @PostMapping
    public BaseResponse create(@RequestBody SampleModel request) {
        SampleData sampleData = new SampleData();
        if (request.getId() != null) {
            sampleData = sampleService.getById(request.getId());
            Preconditions.checkNotNull(sampleData, "不存在的记录");
        }
        EntityUtils.copyProperties(request, sampleData);
        checkProjectRepo.saveAll(sampleData.getCheckProjectList());
        sampleData.setStandards(StringUtils.join(request.getStandard(), ","));
        SampleProduct product = new SampleProduct();
        EntityUtils.copyProperties(request, product, "id", "deleted", "createTime", "updateTime");
        sampleProductRepo.save(product);
        sampleData.setProduct(product);

        EnterpriseInfo inspectedEnterprise = enterpriseRepo.findByEnterpriseId(request.getInspectEnterpriseId()).orElse(new EnterpriseInfo());
        inspectedEnterprise.setEnterpriseName(request.getInspectCompany());
        inspectedEnterprise.setEnterpriseCode(request.getInspectComCode());
        inspectedEnterprise.setEnterpriseAddress(request.getInspectComAddress());
        inspectedEnterprise.setPostcode(request.getInspectComPostNo());
        inspectedEnterprise.setPhone(request.getInspectComPhone());
        inspectedEnterprise.setLinkedUser(request.getInspectComContact());
        enterpriseRepo.save(inspectedEnterprise);
        sampleData.setInspectedEnterprise(inspectedEnterprise);

        EnterpriseInfo productEnterprise = enterpriseRepo.findByEnterpriseId(request.getProductEnterpriseId()).orElse(new EnterpriseInfo());
        productEnterprise.setEnterpriseName(request.getProduceCompany());
        productEnterprise.setEnterpriseCode(request.getProduceComCode());
        productEnterprise.setEnterpriseAddress(request.getProduceComAddress());
        productEnterprise.setPostcode(request.getProduceComPostNo());
        productEnterprise.setPhone(request.getProduceComPhone());
        productEnterprise.setLinkedUser(request.getProduceComContact());
        enterpriseRepo.save(productEnterprise);
        sampleData.setProductEnterprise(productEnterprise);

        EnterpriseInfo delegationEnterprise = enterpriseRepo.findByEnterpriseId(request.getDeputeEnterpriseId()).orElse(new EnterpriseInfo());
        delegationEnterprise.setEnterpriseName(request.getDeputeCompany());
        delegationEnterprise.setEnterpriseCode(request.getDeputeComCode());
        delegationEnterprise.setEnterpriseAddress(request.getDeputeComAddress());
        delegationEnterprise.setPostcode(request.getDeputeComPostNo());
        delegationEnterprise.setPhone(request.getDeputeComPhone());
        delegationEnterprise.setLinkedUser(request.getDeputeComContact());
        enterpriseRepo.save(delegationEnterprise);
        sampleData.setDelegationEnterprise(delegationEnterprise);
        return new SuccessResponse<>(sampleService.saveOrUpdate(sampleData));
    }

    @GetMapping("/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        SampleData sampleData = sampleService.getById(id);
        Preconditions.checkNotNull(sampleData, "不存在的记录。");
        SampleModel sampleModel = new SampleModel(sampleData);
        return new SuccessResponse<>(sampleModel);
    }

    @PostMapping("/list")
    public BaseResponse getList(@PageableDefault(size = Integer.MAX_VALUE) Pageable pageable,
                                @RequestParam(required = false) String status,
                                @RequestParam(required = false) String searchCondition,
                                @RequestBody(required = false) List<SampleOrderRequest> order) {
        List<SampleData> sampleData;
        if (order == null || order.size() == 0) {
            sampleData = sampleService.getList();
        } else {
            List<Sort.Order> orders = Lists.newArrayList();
            for (SampleOrderRequest sampleOrderRequest : order) {
                orders.add(new Sort.Order(sampleOrderRequest.getDirection(), sampleOrderRequest.getProperty()));
            }
            sampleData = sampleService.getList(orders.toArray(new Sort.Order[]{}));
        }
        if (!Strings.isNullOrEmpty(searchCondition)) {
            sampleData = sampleData.stream()
                    .filter(sample -> sample.toString().contains(searchCondition)).collect(Collectors.toList());
        }
        if (!Strings.isNullOrEmpty(status)) {
            sampleData = sampleData.stream()
                    .filter(sample -> status.contains(sample.getSampleStatus().name())).collect(Collectors.toList());
        }
        List<SampleModel> result = Lists.newArrayList();
        for (SampleData sample : sampleData) {
            SampleModel sampleModel = new SampleModel(sample);
            result.add(sampleModel);
        }
        Page pageData = PageResponse.build(result, pageable);
        return new SuccessResponse<>(pageData);
    }

    @DeleteMapping("{id}")
    public BaseResponse deleteById(@PathVariable Long id) {
        sampleService.deleteEntity(id);
        return new SuccessResponse("");
    }

    @PostMapping(value = "{id}/reworks")
    public BaseResponse rework(@PathVariable Long id, @RequestBody SampleReworkRequest reworkRequest) {
        return new SuccessResponse<>(sampleService.reworkSample(id, reworkRequest));
    }

    @Autowired
    private SampleDataRepository sampleDataRepository;

    @DeleteMapping
    public BaseResponse deleteAll(@RequestBody SampleBatchOperation sampleBatchOperation) {
        List<SampleData> data = sampleDataRepository.findAllByIdIn(sampleBatchOperation.getId());
        for (SampleData s : data) {
            s.setDeleted(true);
        }
        sampleService.saveOrUpdateAll(data);
        return new SuccessResponse("");
    }

    @PutMapping
    public BaseResponse commitAll(@RequestBody SampleBatchOperation sampleBatchOperation) {
        List<SampleData> data = sampleDataRepository.findAllByIdIn(sampleBatchOperation.getId());
        for (SampleData s : data) {
            if (!s.getSampleStatus().equals(sampleBatchOperation.getStatus())) {
                s.setSampleStatus(sampleBatchOperation.getStatus());
            }
        }
        sampleService.saveOrUpdateAll(data);
        return new SuccessResponse("");
    }

    @GetMapping("/{id}/reworks")
    public BaseResponse reworkList(@PathVariable Long id, @PageableDefault Pageable pageable) {
        return new SuccessResponse<>(PageResponse.build(sampleService.reworkList(id), pageable));
    }

}
