package com.example.my_fit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .loginPage("/login").permitAll()
                .passwordParameter("password")
                .usernameParameter("username")
                .and()
                .userDetailsService(this.userDetailsService);


        //                .antMatchers("/", "/login", "/register").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .loginProcessingUrl("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/error")
//                .and()
//                .rememberMe()
//                .rememberMeParameter("remember")
//                .rememberMeCookieName("rememberMeCookie")
//                .key("48433e39-e610-4a2c-926c-f86d46f5360a")
//                .tokenValiditySeconds(100)
//                .userDetailsService(userDetailsService)
//                .and()
//                .logout().logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                .permitAll();
    }
}
