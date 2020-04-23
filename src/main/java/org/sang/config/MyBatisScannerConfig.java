package org.sang.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisScannerConfig {
    @Bean
    public MapperScannerConfigurer MapperScannerConfigurer1() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.sang.mapper1");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean1");
        return mapperScannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer MapperScannerConfigurer2() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.sang.mapper2");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean2");
        return mapperScannerConfigurer;
    }
}
