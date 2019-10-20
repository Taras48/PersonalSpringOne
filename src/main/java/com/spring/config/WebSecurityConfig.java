package com.spring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       /* auth.inMemoryAuthentication().withUser("user1").password("$2a$10$z6yOIMaX5/4n1Ps2KbAUGejNcqPEtvt/QgtoNTw6Lz8aWN5dtXNSK").roles("user");
        auth.inMemoryAuthentication().withUser("admin").password("$2a$10$bjUikoAj9nUEFv4UDNHvOOjxpCLb0/5I3pybtWYxxsd1TQDTFjhPe").roles("admin");*/

        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);//прикрутить декодер!!!
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/helloUser").hasAnyRole("admin", "user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .usernameParameter("name")
                .passwordParameter("password")
                //.loginProcessingUrl("/admin")
               // .defaultSuccessUrl("/admin", true)
                .and()
                .csrf().disable();//прочитать что это такое!!!
    }
}
