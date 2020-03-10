package com.dyn.basepro.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "my")
public class ConfigBean {

    private String name;

    private int age;

}
