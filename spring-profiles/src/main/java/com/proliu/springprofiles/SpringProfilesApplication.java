package com.proliu.springprofiles;

import com.proliu.springprofiles.config.HelloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
public class SpringProfilesApplication implements CommandLineRunner {

    @Autowired
    private ConfigurableEnvironment env;

    @Autowired
    private HelloConfig helloConfig;

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start with spring active profile: {}", env.getActiveProfiles());
        helloConfig.setup();
    }
}
