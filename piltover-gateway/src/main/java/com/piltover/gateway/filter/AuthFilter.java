//package com.piltover.gateway.filter;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//
//import reactor.core.publisher.Mono;
// /**
//  * 异常处理filter 可以在这里给各种状态码指定
//  * @author Administrator
//  *
//  */
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
// 
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
//        //重定向(redirect)到登录页面
//        if (StringUtils.isBlank(token)) {
//            String url = "http://想跳转的网址";
//            ServerHttpResponse response = exchange.getResponse();
//            //303状态码表示由于请求对应的资源存在着另一个URI，应使用GET方法定向获取请求的资源
//            response.setStatusCode(HttpStatus.SEE_OTHER);
//            response.getHeaders().set(HttpHeaders.LOCATION, url);
//            return response.setComplete();
//        }
//        return chain.filter(exchange);
//    }
// 
//    @Override
//    public int getOrder() {
//        return -100;
//    }
//}
