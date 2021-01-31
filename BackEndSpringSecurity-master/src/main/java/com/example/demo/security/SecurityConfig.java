package com.example.demo.security;

import com.example.demo.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configurable
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    AppUserDetailsService appUserDetailsService;

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        System.out.println("Test Login");
        auth.userDetailsService(appUserDetailsService);
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        System.out.println("********** configure httpSecurity **********");
        http.csrf().disable();
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/utilisateur","not-found").permitAll()
                .anyRequest()
                .permitAll()
                .and()
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout","POST")).and()
                .httpBasic()
                .and()
                .csrf().disable(); //disable the CSRF - Cross Site Request Forgery
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){return  new BCryptPasswordEncoder(); }

}
