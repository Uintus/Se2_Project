package com.Se2.MusicPlatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//        return http.build();
//    }
//}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/signin","/home", "/style/**","/img/**", "/utility/**", "/fonts/**", "/audio/**")
//
//                        .permitAll()
//                        .anyRequest().authenticated())
//                .formLogin((form) -> form.loginPage("/signin")
//                        .permitAll()
//                        .defaultSuccessUrl("/signin?success=true")
//                        .failureUrl("/signin?success=false")
//                        .loginProcessingUrl("/j_spring_security_check")
//
//                );
//
////                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }


//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user1")
//                .password(passwordEncoder().encode("123"))
//                .authorities("ROLE_USER");
//    }








    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests(registry -> { registry
            .requestMatchers("/signin", "/style/**","/img/**", "/utility/**").permitAll()
                    .anyRequest().authenticated();

                })
                .formLogin(form -> form
                        .loginPage("/signin")
                        .permitAll()
//                      .defaultSuccessUrl("/signin?success=true")
                        .failureUrl("/signin?success=false")
                        .defaultSuccessUrl("/main", true)
                        .loginProcessingUrl("/j_spring_security_check"))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("user1")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(normalUser);
    }


}