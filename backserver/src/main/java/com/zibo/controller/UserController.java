package com.zibo.controller;

import com.zibo.entity.Account;
import com.zibo.response.BaseResponse;
import com.zibo.response.SuccessResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController extends BaseController {
    @GetMapping("/me")
    public BaseResponse me() {
        return new SuccessResponse<>(getCurrentAccount());
    }

    @PostMapping
    public BaseResponse create(@RequestBody Account account) {
        return new SuccessResponse<>(userService.saveOrUpdate(account));
    }
}
