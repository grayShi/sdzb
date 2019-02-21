package com.zibo.repository;

import com.zibo.entity.SampleProductRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SampleProductRecordRepository extends PagingAndSortingRepository<SampleProductRecord, Long> {
    List<SampleProductRecord> findAllBySampleProductIdAndOpType(String productId, SampleProductRecord.OpType opType);
}
