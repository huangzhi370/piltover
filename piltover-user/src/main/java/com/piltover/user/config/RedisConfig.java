package com.piltover.user.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;


/**
 * 
 * @author Administrator
 *
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.timeout}")
	private int timeout;
	@Value("${spring.redis.pool.maxIdle}")
	private Integer maxIdle;
	@Value("${spring.redis.pool.maxTotal}")
	private Integer maxTotal;
	@Value("${spring.redis.pool.maxWaitMillis}")
	private Integer maxWaitMillis;
	@Value("${spring.redis.minEvictableIdleTimeMillis}")
	private Integer minEvictableIdleTimeMillis;
	@Value("${spring.redis.numTestsPerEvictionRun}")
	private Integer numTestsPerEvictionRun;
	@Value("${spring.redis.timeBetweenEvictionRunsMillis}")
	private long timeBetweenEvictionRunsMillis;
	@Value("${spring.redis.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${spring.redis.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${spring.redis.testOnReturn}")
	private boolean testOnReturn;
	
	@Bean(name = "genericObjectPoolConfig")
	@Primary
    public GenericObjectPoolConfig<JedisPoolConfig> genericObjectPoolConfig() {
        GenericObjectPoolConfig<JedisPoolConfig> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMinIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        poolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        poolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        poolConfig.setTestOnBorrow(testOnBorrow);
        poolConfig.setTestWhileIdle(testWhileIdle);
        poolConfig.setTestOnReturn(testOnReturn);
        return poolConfig;
    }
	
	@Bean(name = "lettuceClientConfiguration")
	@Primary
    public LettuceClientConfiguration lettuceClientConfiguration(
    		@Qualifier("genericObjectPoolConfig")GenericObjectPoolConfig<JedisPoolConfig> genericObjectPoolConfig){
        //构造LettucePoolingClientConfiguration对象，同时加入连接池配置信息
        LettucePoolingClientConfiguration build = LettucePoolingClientConfiguration.builder().poolConfig(genericObjectPoolConfig).build();
        return build;
    }
	
	@Bean(name = "lettuceConnectionFactory")
	@Primary
	public LettuceConnectionFactory lettuceConnectionFactory(
			@Qualifier("lettuceClientConfiguration")LettuceClientConfiguration lettuceClientConfiguration) {
		 RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//	        redisStandaloneConfiguration.setDatabase(database);
	        redisStandaloneConfiguration.setHostName(host);
	        redisStandaloneConfiguration.setPort(port);
	        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

//	        LettuceClientConfiguration.LettuceClientConfigurationBuilder lettuceClientConfigurationBuilder = LettuceClientConfiguration.builder();
	        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
	        return lettuceConnectionFactory;
	}
	
	  //配置RedisTemplate
	@Bean(name = "jedisTemplate")
	@Primary
    public RedisTemplate<String, Object> redisTemplate(
    		@Qualifier("lettuceConnectionFactory")LettuceConnectionFactory lettuceConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        //设置key的存储方式为字符串
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        //注入Lettuce连接工厂
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }
	

 
}
