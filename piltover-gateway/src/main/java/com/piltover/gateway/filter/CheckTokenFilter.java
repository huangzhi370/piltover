package com.piltover.gateway.filter;

import java.net.URI;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import com.piltover.common.utils.RedisUtils;

import reactor.core.publisher.Mono;
/**
 * 续签token
 * @author Administrator
 *
 */

@Component
public class CheckTokenFilter implements GlobalFilter,Ordered  {
	
	@Autowired
	private RedisUtils redisUtils;

	 @Override
	    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		 
		 	URI url=exchange.getRequest().getURI();
		 	//排除登出方法
		 	if(url.getPath().indexOf("logout")==-1&&url.getPath().indexOf("oauth")==-1){
		 		String token = exchange.getRequest().getHeaders().getFirst("Authorization");
		 			Boolean tokenError=false;
			       if(!StringUtils.isEmpty(token)&&token.indexOf("Bearer")!=-1){
			    	   String[] num=token.split("Bearer ");
			    	   token=num[1];
			       }else{
			    	   tokenError=true;
			       }
			        //返回401状态码和提示信息
			        HttpStatus status=exchange.getResponse().getStatusCode();
			        if(status.value()==200){
			        	Set<String> tokenstr=	redisUtils.getKeys("*"+token+"*");
			        	if(tokenstr!=null&&tokenstr.size()>0){
			        		//重新设置下过期时间 相当于续签
					        tokenstr.forEach(key->redisUtils.setKeyTime(key,3600));
			        	}else{
			        		tokenError=true;
			        	}
			        }
			        //如果token不合法或者没有token 就跳转到登陆页面
			        if(tokenError){
			            String url2 = "http://127.0.0.1:8080";
			            ServerHttpResponse response = exchange.getResponse();
			            //303状态码表示由于请求对应的资源存在着另一个URI，应使用GET方法定向获取请求的资源
			            response.setStatusCode(HttpStatus.SEE_OTHER);
			            response.getHeaders().set(HttpHeaders.LOCATION, url2);
			            return response.setComplete();
			        }
		 	}
		       
	        return chain.filter(exchange);
	    }
	 
	    @Override
	    public int getOrder() {
	        return -100;
	    }

}
