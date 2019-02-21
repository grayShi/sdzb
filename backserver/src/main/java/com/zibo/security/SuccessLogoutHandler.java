package com.zibo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessLogoutHandler implements LogoutSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SuccessLoginHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //do nothing
        if (authentication != null && authentication.isAuthenticated()) {
            LOGGER.info("User {} logout success.", authentication.getName());
        }
    }
}
