package com.proliu.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ExceptionFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        RequestPath requestPath = exchange.getRequest().getPath();

        if ("/error".equalsIgnoreCase(requestPath.toString())) {
            log.info("============ Filter Exception ============ {}", requestPath.toString());

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filter Exception");
        }
        return chain.filter(exchange);
    }
}
