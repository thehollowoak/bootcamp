package com.lse.spring.example.jta;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.lse.spring.example")
@PropertySources({
        @PropertySource("classpath:/application.properties")
})
public class TestConfig {


}