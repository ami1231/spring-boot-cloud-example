package lotteryaward.common.cache;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author Ami
 * cache Interface
 */
public interface LotteryAwardCache {
	
	void del(String key);
	void set(String key,String value,int liveTime,TimeUnit unit);
	void set(String key,String value);
	
	void putObj(String key, Object value);
	void putObj(String key, Object value,int liveTime,TimeUnit unit);
	<T> T getObj(String key, Class<T> cls);
	
	<T> T getCollectionObj(String key, TypeToken<T> type);
	
	String get(final String key);
	Set<String> keys(final String pattern);
	boolean exists(final String key);

}//class LGCache
