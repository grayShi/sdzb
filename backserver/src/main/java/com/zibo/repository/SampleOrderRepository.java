package com.zibo.repository;

import com.zibo.entity.SampleOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
public interface SampleOrderRepository extends PagingAndSortingRepository<SampleOrder, Long> {
    List<SampleOrder> findAllByIdIn(Long[] ids);
}
