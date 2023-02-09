package com.proliu.springprofiles.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("prod")
public class ProdHelloConfig implements HelloConfig {

    @Override
    public void setup() {
        log.info("Setting up config for prod environment.");
    }
}
