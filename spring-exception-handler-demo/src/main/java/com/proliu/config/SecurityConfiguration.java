package com.proliu.config;

import com.proliu.filter.ExceptionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.zalando.problem.spring.webflux.advice.security.SecurityProblemSupport;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Import(SecurityProblemSupport.class)
public class SecurityConfiguration {

    @Autowired
    private SecurityProblemSupport problemSupport;

    @Autowired
    private ExceptionFilter  exceptionFilter;

    @Bean
    public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {

        http.csrf().disable();

        http.addFilterAt(exceptionFilter, SecurityWebFiltersOrder.HTTP_BASIC);

        http.exceptionHandling()
                .authenticationEntryPoint(problemSupport)
                .accessDeniedHandler(problemSupport);

        http.authorizeExchange((authorize) -> authorize
                        .pathMatchers("/tasks/**").permitAll()
                .anyExchange().denyAll());

        return http.build();
    }

}
