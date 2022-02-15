package com.project.RestaurantManagementSystem.security;


import com.project.RestaurantManagementSystem.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/adminRestaurant","/viewDineIn","/viewDineIn/*","/viewDineInTime/*","/addDineInTime/*","/viewTables/*","/addTables/*").hasRole("ADMIN")
                .antMatchers("/updateCustomerProfile","/cart","/restaurant","/booked","*/booked/*","*/dineIn","/dineIn","/dineIn/*").hasRole("USER")
                .antMatchers("/").permitAll()
                .antMatchers("/register","/login").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/success");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
