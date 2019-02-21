package com.zibo.repository;

import com.zibo.constants.DictType;
import com.zibo.entity.GlobalDict;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
public interface DictRepository extends PagingAndSortingRepository<GlobalDict, Long> {
    List<GlobalDict> findAllByType(DictType type);
}
