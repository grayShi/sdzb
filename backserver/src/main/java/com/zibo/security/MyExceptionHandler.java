package com.zibo.security;

import com.zibo.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author 11369
 * @date 2018/5/19
 */
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, new ErrorResponse(e.getMessage()), new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
