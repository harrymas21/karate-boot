package com.carbonara.karateboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/app/secure/**").hasAnyRole("ADMIN","USER")
		.and().formLogin()  //login configuration
                .loginPage("/app/login")
                .loginProcessingUrl("/app-login")
                .usernameParameter("app_username")
                .passwordParameter("app_password")
                .defaultSuccessUrl("/app/secure/user-home")	
		.and().logout()    //logout configuration
		.logoutUrl("/app-logout") 
		.logoutSuccessUrl("/app/login")
		.and().exceptionHandling() //exception handling configuration
		.accessDeniedPage("/app/error");
	} 
        @Autowired
   	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
              auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}
        
        @Bean
        public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        }
} 
