package com.tfms.config;

import com.tfms.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService(){
        //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //关闭防止网站攻击
        http.csrf().disable();

        http.authorizeRequests()
                //TODO
                .anyRequest().permitAll()


//                .antMatchers("/","/user/regist").permitAll()//放行注册页
//                .antMatchers("/webjars/**","/css/**","/img/**").permitAll()//放行静态资源
//                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
//                .and()
//                .formLogin()
//                .loginPage("/user/login")   //  登录页
//                .loginProcessingUrl("/login") //处理表单的路径
//                .failureUrl("/error").permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/");
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //验证service
        //security的密码需要指定加密格式
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());

    }
}

