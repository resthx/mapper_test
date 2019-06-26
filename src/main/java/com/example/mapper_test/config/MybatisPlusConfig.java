package com.example.mapper_test.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
/*import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;*/
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * ClassName: MybatisPlusConfig
 * Description:
 * date: 2019/6/22 11:43
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class MybatisPlusConfig {
    /***
     * plus 的性能优化
     * @return
     */
/*    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        *//*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*//*
        performanceInterceptor.setMaxTime(1000);
        *//*<!--SQL是否格式化 默认false-->*//*
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }*/

    /**
     * @Description : mybatis-plus分页插件
     * ---------------------------------
     * @Author : Liang.Guangqing
     * @Date : Create in 2017/9/19 13:59
     */
/*    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }*/


    /**
     * @Description : druid注入
     * ---------------------------------
     * @Author : Liang.Guangqing
     * @Date : Create in 2018/1/3 17:38
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid" )
    public DataSource dataSource() {
        return  DruidDataSourceBuilder.create().build();
    }
}
