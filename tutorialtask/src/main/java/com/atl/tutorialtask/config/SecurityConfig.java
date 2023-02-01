package com.atl.tutorialtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.atl.tutorialtask.config.UserRoles.ADMIN;
import static com.atl.tutorialtask.config.UserRoles.GUEST;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1")
                .permitAll()
                .antMatchers("/tutorials/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails majidova = User.builder()
                .username("majidova")
                .password(passwordEncoder.encode("636847482mp"))
                .roles(ADMIN.name())
                .build();


        UserDetails sara = User.builder()
                .username("sara")
                .password(passwordEncoder.encode("sara12345"))
                .roles(GUEST.name())
                .build();
        return new InMemoryUserDetailsManager(majidova, sara);
    }
}
