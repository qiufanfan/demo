package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.sql.DataSource;

@Deprecated
@Configuration
public class MyDataSourceConfig {
    //默认的自动配置是判断容器中没有才会配@ConditioalOnMissingBean（DataSource。class）
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
        return druidDataSource;
    }
}
