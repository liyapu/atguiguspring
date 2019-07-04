package com.lyp.learn.demo.beans.annotation.qualifier;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 该文件作为Spring的配置文件
 */
@Configuration
@ComponentScan(basePackages = "com.lyp.learn.demo.beans.annotation.qualifier")
public class SpringConfig {
}
