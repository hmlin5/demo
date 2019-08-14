package com.hmlin5.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * @ Author ：linhaomiao
 * @ Date   ：2018-11-04
 * @ Desc   ：
 */
@SpringBootConfiguration
@ComponentScan(value="com.hmlin5.demo")
@MapperScan(basePackages= {"com.hmlin5.demo.*.mapper"})
public class AppContextConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "druid")//获取application.properties配置文件中的配置项给dataSource对应的属性
    public DataSource dataSource() {
       return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
/*
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "bonecp")//获取application.properties配置文件中的配置项给dataSource对应的属性
    public DataSource dataSource() {
       return DataSourceBuilder.create().type(BoneCPDataSource.class).build();
    }
*/



}


