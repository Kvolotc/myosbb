package com.softserve.osbb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by cavayman on 30.08.2016.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "restservice";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/restful/report/**").permitAll()
                .antMatchers("/restful/attachment").permitAll()
                .antMatchers("/restful/house/**").permitAll()
                .antMatchers("/restful/house/all/**").permitAll()
                .antMatchers("/restful/osbb").permitAll()
                .antMatchers("/restful/address/**").permitAll()              
                .antMatchers("/restful/apartment/**").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/registration/osbb").permitAll()
                .antMatchers("/validEmail").permitAll()
                .antMatchers("/forgotEmail").permitAll()
                .antMatchers("/restful/report**").permitAll()
                .antMatchers("/restful/report/**").permitAll()
                .antMatchers(HttpMethod.POST,"/restful/user/**").permitAll()
                .antMatchers("/restful/**").authenticated();

    }


}