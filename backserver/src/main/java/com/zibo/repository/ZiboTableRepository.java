package com.zibo.repository;

import com.zibo.entity.ZiboTable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
public interface ZiboTableRepository extends PagingAndSortingRepository<ZiboTable, Long> {
    List<ZiboTable> findAllByIdIn(Long[] ids);
}
