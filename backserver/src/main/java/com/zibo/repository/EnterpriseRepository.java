package com.zibo.repository;

import com.zibo.entity.EnterpriseInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EnterpriseRepository extends PagingAndSortingRepository<EnterpriseInfo, Long> {
    Optional<EnterpriseInfo> findByEnterpriseId(String enterpriseId);
}
