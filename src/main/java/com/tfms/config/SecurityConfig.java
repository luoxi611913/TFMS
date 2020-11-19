package com.tfms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //关闭防止网站攻击
        http.csrf().disable();

        //测试需要权限level1 以及level2
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/test/level1").hasRole("level1")
                .antMatchers("/test/level2").hasRole("level2");

        //没有权限就去登陆
        http.formLogin().usernameParameter("username")
                        .passwordParameter("password")
                .loginPage("/user/login")
                .loginProcessingUrl("/login")
                .failureUrl("/error")
        ;

        //注销退回主页
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //从内存中取用户数据
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("tianfan").password(new BCryptPasswordEncoder().encode("123456")).roles("level1","level2").and()
                .withUser("youke").password(new BCryptPasswordEncoder().encode("123456")).roles("level1");
    }
}

