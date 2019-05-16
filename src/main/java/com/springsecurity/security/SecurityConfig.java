package com.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //  auth.authenticationProvider(authenticationProvider());
    auth.inMemoryAuthentication().withUser("dan").password(passwordEncoder().encode("dan123")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
            .and()
            .withUser("ghada").password(passwordEncoder().encode("ghada")).roles("USER");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/signataire/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic();


    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
