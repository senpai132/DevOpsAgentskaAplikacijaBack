package com.DevOps2022.agentapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.DevOps2022.agentapplication.security.TokenUtils;
import com.DevOps2022.agentapplication.security.auth.TokenAuthenticationFilter;
import com.DevOps2022.agentapplication.services.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsServiceImpl jwtUserDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Injektujemo implementaciju iz TokenUtils klase kako bismo mogli da koristimo njene metode za rad sa JWT u TokenAuthenticationFilteru
    @Autowired
    private TokenUtils tokenUtils;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .antMatchers("/auth/**").permitAll()
        .antMatchers("/company/**").permitAll()
        .antMatchers("/jobopening/**").permitAll()
        .antMatchers("/comment/**").permitAll()
        .antMatchers("/salary/**").permitAll()
        .antMatchers("/interview/**").permitAll()
        .anyRequest().authenticated().and()
        // za development svrhe ukljuci konfiguraciju za CORS iz WebConfig klase
        .cors().and()

        // umetni custom filter TokenAuthenticationFilter kako bi se vrsila provera JWT tokena umesto cistih korisnickog imena i lozinke (koje radi BasicAuthenticationFilter)
        .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
                BasicAuthenticationFilter.class);
                
        http.csrf().disable();

        http.headers().frameOptions().disable();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        //web.ignoring().antMatchers(HttpMethod.GET, "/test/comm");
        return (web) -> web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", 
                "/*.html", "/favicon.ico", "/**/*.html",
                "/**/*.css", "/**/*.js");
    }
}
