package ru.rogov.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:/application-${property.environment}.properties")
@ComponentScan({"ru.rogov.rest",
        "ru.rogov.utils"})
public class TestConfig {

    private static final Logger log = LoggerFactory.getLogger(TestConfig.class);

}
