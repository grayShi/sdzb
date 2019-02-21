package com.zibo.controller;

import com.zibo.entity.Account;
import com.zibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author shaoxiong.zhan
 */
@RestController
public class BaseController {
    @Autowired
    protected UserService userService;

    public String getCurrentUsername() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }

    public Account getCurrentAccount() {
        String phoneNumber = getCurrentUsername();
        Optional<Account> account = Optional.ofNullable(userService.getByPhoneNumber(phoneNumber));
        Account fakeAccount = userService.getById(0L);
        return account.orElse(fakeAccount);
    }
}
