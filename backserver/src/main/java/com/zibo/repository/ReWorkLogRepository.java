package com.zibo.repository;

import com.zibo.entity.ReWorkLog;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
public interface ReWorkLogRepository extends PagingAndSortingRepository<ReWorkLog, Long> {
    List<ReWorkLog> findAllBySampleDataId(Long id);
}
