package com.zibo.service;

import com.zibo.entity.EnterpriseInfo;
import com.zibo.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

/**
 * @author shaoxiong.zhan
 */
@Service
public class EnterpriseService extends BasicService<EnterpriseInfo, Long> {
    private EnterpriseRepository enterpriseRepo;

    public EnterpriseService(EnterpriseRepository enterpriseRepo) {
        super(enterpriseRepo);
        this.enterpriseRepo = enterpriseRepo;
    }
}
