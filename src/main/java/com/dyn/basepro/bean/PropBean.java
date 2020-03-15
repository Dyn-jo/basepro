package com.dyn.basepro.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置文件中文乱码问题：
 * 1.默认配置文件不是utf-8编码，可以手动指定编码格式
 * 2.或者在记事本中使用utf-8编码，再粘到properties文件中
 */
@PropertySource(value = "classpath:prop.properties", encoding = "UTF-8")
@Configuration
@Data
public class PropBean {

    // 如果不存在该配置，默认值为null
    @Value("${info:}")
    private String info;

}
