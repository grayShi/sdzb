package com.zibo.repository;

import com.zibo.entity.SampleProduct;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SampleProductRepository extends PagingAndSortingRepository<SampleProduct, Long> {
}
