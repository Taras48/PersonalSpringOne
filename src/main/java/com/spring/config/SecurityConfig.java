package com.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override///??????????? замена из базы имени
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("uaer")
                .roles("user");
        auth.inMemoryAuthentication().withUser("admin").password("admin")
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**","/helloUser")
                .access("hasRole('ROLE_admin')")
                .antMatchers("/helloUser")
                .access("hasRole('ROLE_user')")
                .and().formLogin().defaultSuccessUrl("/index", false);

    }
}
