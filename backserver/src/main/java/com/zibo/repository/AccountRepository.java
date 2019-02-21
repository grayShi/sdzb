package com.zibo.repository;

import com.zibo.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByUsername(String username);

    Account findByPhoneNumber(String phoneNumber);

    List<Account> findAllByDeptId(Long deptId);
}
