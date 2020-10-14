package com.piltover.report;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //使用seata代理来代理事务
@ComponentScan("com.piltover.report")
@MapperScan("com.piltover.report.dao")
public class ReportApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ReportApp.class, args);
    }
}
