package com.spring.codeblog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ImplementsUserDetailsService implementsUserDetailsService;

    private static final String[] AUTH_LIST = {
            "/",
            "/posts",
            "/posts/{id}",
            "/usuarioForm"
    };

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_LIST).permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(implementsUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/bootstrap/**");
    }

}
