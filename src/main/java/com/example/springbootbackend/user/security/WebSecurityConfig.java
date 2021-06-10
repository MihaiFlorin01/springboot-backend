package com.example.springbootbackend.user.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().
                antMatchers(HttpMethod.GET, "/api/v1/websites").permitAll().
                antMatchers(HttpMethod.POST, "/api/v1/websites").permitAll().
                antMatchers(HttpMethod.GET, "/api/v1/websites/{id}").permitAll().
                antMatchers(HttpMethod.PUT, "/api/v1/websites/{id}").permitAll().
                antMatchers(HttpMethod.DELETE, "/api/v1//websites/delete/{id}").permitAll().
                antMatchers(HttpMethod.POST, "/api/v1/register").permitAll().
                antMatchers(HttpMethod.POST, "/api/v1/login").permitAll().
                antMatchers(HttpMethod.POST, "/api/v1/period").permitAll().
                antMatchers(HttpMethod.GET, "/api/v1/email/{username}").permitAll()
                .anyRequest().authenticated();

    }

}
