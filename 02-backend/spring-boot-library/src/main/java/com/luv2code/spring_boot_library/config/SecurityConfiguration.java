package com.luv2code.spring_boot_library.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /**
         * The course in 161 section, the code doesn't work for me due to the version of the spring boot and okta
         * I have updated okta-spring-boot-starter to 3.0.7
         * and do the following code, it works for me at least can compile
         */

        // disable cross request site forgery
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/api/books/secure/**").authenticated()
                                .requestMatchers("/api/books/**", "/api/reviews/**", "/api/histories/**").permitAll())
                .oauth2ResourceServer((oauth2) -> oauth2
                        .jwt(Customizer.withDefaults())
                );

        // add cors filter
        http.cors(Customizer.withDefaults());
        // add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());
        // Force a non-empty response body to make unauthorized response body more friendly.
        Okta.configureResourceServer401ResponseBody(http);
        return http.build();
    }
}
