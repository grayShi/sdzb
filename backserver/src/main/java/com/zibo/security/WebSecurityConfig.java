package com.zibo.security;

import com.zibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * @author shaoxiong.zhan
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @Bean
    SuccessLoginHandler successLoginHandler() {
        return new SuccessLoginHandler();
    }

    @Bean
    SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//may cause post api rejected
        http.authorizeRequests()
                .antMatchers("/api/users/**")
                .permitAll()
//                .antMatchers("/api/*", "/api/**").authenticated()
                .and()
                .userDetailsService(userService)
                .authenticationProvider(userAuthenticationProvider)
                .httpBasic()
                .authenticationEntryPoint(new AuthenticationEntryPointImpl())
                .realmName("jzoa")
                .and()
                .logout()
                .logoutUrl("/api/users/logout")
                .logoutSuccessHandler(new SuccessLogoutHandler())
                .clearAuthentication(true)
                .permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();//may cause post api rejected
//        http.authorizeRequests().antMatchers("**").permitAll();
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(new NoPasswordEncoder());
//    }

    public class NoPasswordEncoder implements PasswordEncoder {

        @Override
        public String encode(CharSequence rawPassword) {
            return rawPassword.toString();
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return rawPassword.toString().equals(encodedPassword);
        }
    }
}
