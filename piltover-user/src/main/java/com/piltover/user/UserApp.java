package com.piltover.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //使用seata代理来代理事务
@ComponentScan("com.piltover.user")
@MapperScan("com.piltover.user.dao")
@EnableFeignClients
public class UserApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(UserApp.class, args);
    }
}
