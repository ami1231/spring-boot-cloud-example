package lotteryaward.chart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.google.gson.Gson;

import lotteryaward.common.cache.LotteryAwardCache;
import lotteryaward.common.cache.RedisCache;

/**
 * 
 * @author Ami
 *
 */
@Configuration
public class RedisTemplateConfig {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
	
	@Bean
	public LotteryAwardCache lotteryAwardCache(Gson gson,RedisTemplate<String,Object> redisTemplate){
		RedisCache redisCache = new RedisCache();
		redisCache.setRedisTemplate(redisTemplate);
		return redisCache;
	}
	
}