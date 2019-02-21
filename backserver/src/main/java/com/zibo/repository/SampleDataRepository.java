package com.zibo.repository;

import com.zibo.entity.SampleData;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
public interface SampleDataRepository extends PagingAndSortingRepository<SampleData, Long> {
    List<SampleData> findAllByIdIn(Long[] ids);
}
