package com.piltover.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {
"com.piltover.gateway.*",
"com.piltover.common.*"})
public class GatewayApp 
{
    public static void main( String[] args)
    {
        SpringApplication.run(GatewayApp.class, args);
    }
}
