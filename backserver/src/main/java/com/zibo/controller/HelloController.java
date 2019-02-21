package com.zibo.controller;

import com.google.common.collect.Lists;
import com.zibo.response.BaseResponse;
import com.zibo.response.SuccessResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shaoxiong.zhan
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping
    public BaseResponse printWelcome() {
        return new SuccessResponse("hello");
    }

    @PostMapping
    public BaseResponse printList(@RequestBody String name) {
        List<String> list = Lists.newArrayList(name);
        return new SuccessResponse<>(list);
    }
}
