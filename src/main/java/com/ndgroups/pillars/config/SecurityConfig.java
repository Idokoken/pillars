package com.ndgroups.pillars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/h2***", "/signup", "/css/**", "/js/**").permitAll()
                .antMatchers("/api/user***").hasRole("ADMIN")
                .and().httpBasic().and().csrf().disable();

        httpSecurity.headers().frameOptions().disable();

        httpSecurity.formLogin()
                .loginPage("/login")
                .permitAll();

        httpSecurity.formLogin()
                .defaultSuccessUrl("/home", true);

        httpSecurity.logout(l -> l
                .logoutSuccessUrl("/login").permitAll());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin")
                .password(passwordEncoder.encode("admin")).roles("ADMIN");
    }

}
