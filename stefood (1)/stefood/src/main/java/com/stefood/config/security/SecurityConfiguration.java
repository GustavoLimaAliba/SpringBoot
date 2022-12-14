package com.stefood.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired

    private AutenticacaoService autenticacaoService;
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers(HttpMethod.GET, "/pedidos").permitAll()
                .antMatchers(HttpMethod.GET, "/pedidos/*").permitAll()
               .antMatchers(HttpMethod.POST, "/pedidos").permitAll()
               .antMatchers(HttpMethod.DELETE, "/pedidos/*").permitAll()
               .antMatchers(HttpMethod.POST, "/auth").permitAll()
               .antMatchers(HttpMethod.GET, "/lojas").permitAll()
               .antMatchers(HttpMethod.POST, "/lojas").permitAll()
               .antMatchers(HttpMethod.PUT, "/lojas/*").permitAll()
               .antMatchers(HttpMethod.DELETE, "/lojas/*").permitAll()
               .antMatchers(HttpMethod.GET, "/lojas/*").permitAll()
               .anyRequest().authenticated()
               .and().csrf().disable()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }




}
