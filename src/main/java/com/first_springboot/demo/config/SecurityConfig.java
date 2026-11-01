package com.first_springboot.demo.config;

import com.first_springboot.demo.config.token.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

@Autowired
private AuthFilter authFilter;

//    @Bean
//public UserDetailsManager userDetailsManager(DataSource source){
//
//    JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(source);
//
//    return userDetailsManager;
//}






    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
http.csrf(csrfToken -> csrfToken.disable());

        http.authorizeHttpRequests(auth -> auth  .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll().anyRequest().authenticated()

                 // .requestMatchers(HttpMethod.GET,"/players/**").hasAllRoles("ADMIN").anyRequest().authenticated()
                 // .requestMatchers(HttpMethod.GET,"/players/name").hasAllRoles("MANGAR").anyRequest().authenticated()
                )

//                .formLogin(Customizer.withDefaults())

                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable);

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//.anyRequest().authenticated()
    //.anyRequest().permitAll()




//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails userDetails1 = User.withUsername("mahmoud").password("{noop}123").roles("ADMIN","MANGAR","USER").build();
//        UserDetails userDetails2 = User.withUsername("ali").password("{noop}456").roles("MANGAR","USER").build();
//        UserDetails userDetails3 = User.withUsername("omar").password("{noop}789").roles("USER").build();
//
//
//
//
//
//        return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);
//    }
//
//


@Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }

}
