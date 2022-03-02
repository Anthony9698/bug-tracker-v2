package com.bugtrackerv2.server.security;

import com.bugtrackerv2.server.filter.CustomAuthenticationFilter;
import com.bugtrackerv2.server.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration // BRINGS INTO SPRING CONTEXT, GETS EXECUTED ON STARTUP
@EnableWebSecurity // NEEDED TO CUSTOMIZE SPRING SECURITY
@RequiredArgsConstructor // INJECTS SPRING BEANS
public class SecurityConfig extends WebSecurityConfigurerAdapter { // ADAPTER NEEDED TO OVERRIDE BOTH ITS CONFIG METHODS
    private final UserDetailsService userDetailsService; // CORE INTERFACE THAT LOADS USER SPECIFIC DATA NOTE: IMPL CLASS IS AppUserServiceImpl
    private final BCryptPasswordEncoder bCryptPasswordEncoder; // PASSWORD ENCODING SCHEMA

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // CONFIGURES THE AUTHENTICATION MANAGER W/ CORRECT PROVIDER
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); // AND PASSWORD ENCODING SCHEMA
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // CONFIGURES WEB SECURITY (PUBLIC URLS, PRIVATE URLS, AUTHORIZATION, etc.)
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/api/login/**", "/api/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(GET, "/api/user/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(POST, "/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
