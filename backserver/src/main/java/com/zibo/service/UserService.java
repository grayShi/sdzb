package com.zibo.service;

import com.zibo.entity.Account;
import com.zibo.repository.AccountRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BasicService<Account, Long> implements UserDetailsService {
    private AccountRepository userRepo;

    UserService(AccountRepository userRepo) {
        super(userRepo);
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = getByPhoneNumber(s);
        if (account == null) {
            throw new BadCredentialsException("登录名[" + s + "]不存在!");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account.getAuthority());
        grantedAuthorities.add(grantedAuthority);
        return new User(s, account.getPassword(), grantedAuthorities);
    }

    public Account getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Account getByPhoneNumber(String phone) {
        return userRepo.findByPhoneNumber(phone);
    }

    public List<Account> getListByDeptId(Long deptId) {
        return userRepo.findAllByDeptId(deptId);
    }
}
