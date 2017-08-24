package lotteryaward.common.cache;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author Ami
 *
 */
public class RedisCache implements LotteryAwardCache {

	private RedisTemplate<String,Object> redisTemplate;
	
	private Gson gson;
	
	@Override
	public void putObj(String key, Object value) {
		redisTemplate.opsForValue().set(key, gson.toJson(value));
	}

	@Override
	public void putObj(String key, Object value, int liveTime,TimeUnit unit) {
		redisTemplate.opsForValue().set(key, gson.toJson(value), liveTime, unit);
	}

	@Override
	public <T> T getObj(String key, Class<T> cls) {
		String json = get(key);
		return gson.fromJson(json, cls);
	}
	
	@Override
	public <T> T getCollectionObj(String key, TypeToken<T> typeToken) {
		String json = get(key);		
		return gson.fromJson(json, typeToken.getType());
	}

	@Override
	public void del(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void set(String key, String value, int liveTime, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, value,liveTime,unit);		
	}
	

	@Override
	public String get(final String key) {
		return gson.toJson(redisTemplate.opsForValue().get(key));
	}

	@Override
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}
	
	@Override
	public Set<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}
	
}
