package com.zibo.repository;

import com.zibo.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author shaoxiong.zhan
 */
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}
