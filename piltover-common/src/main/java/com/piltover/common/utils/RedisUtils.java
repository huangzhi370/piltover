package com.piltover.common.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * Redis工具类
 *
 * @author Alex
 * @date 2018-07-17 21:12
 */
@Service("vigorRedisUtils")
public class RedisUtils {
	/**
	 * 日志输出
	 */
	private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);
	@Autowired
	@Qualifier("jedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;
	
    /**  默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1;

    /**
     * 数据存储
     * 
     * @param key
     * @param value
     * @param expire 秒
     */
	public void set(String key, Object value, long expire){
		try {
			redisTemplate.opsForValue().set(key, value);  
			if(expire != NOT_EXPIRE){
				redisTemplate.expire(key, expire, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			logger.error("Reis存储数据[key="+key+"]异常:["+e+"]");
		}
    }
	
	public RedisConnectionFactory getRedisContion(){
		return redisTemplate.getConnectionFactory();
	}

    public void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 数据获取
     * @param key
     * @param clazz
     * @param expire 秒
     * @return
     */
    public <T> T get(String key, Class<T> clazz, long expire) {
    	try {
    		String value = (String)redisTemplate.opsForValue().get(key);
        	if(expire != NOT_EXPIRE){
        		redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        	}
        	return value == null ? null : fromJson(value, clazz);
    	} catch (Exception e) {
    		logger.error("Reis获取数据[key="+key+"]异常:["+e+"]");
		}
    	return null;
    }
    
    /**
     * 数据获取
     * @param key
     * @param clazz
     * @param expire 秒
     * @return
     */
    public Map<Object,Object> getMap(String key,  long expire) {
    	try {
			@SuppressWarnings("unchecked")
			Map<Object,Object> value = (Map<Object,Object>)redisTemplate.opsForValue().get(key);
        	if(expire != NOT_EXPIRE){
        		redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        	}
        	return value;
    	} catch (Exception e) {
    		logger.error("Reis获取数据[key="+key+"]异常:["+e+"]");
		}
    	return null;
    }
    
    /**
     * 设置key过期时间
     */
    public void setKeyTime(String key, int time){
    	redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }
    /**
     * 根据key模糊查找所有匹配的key
     * @param key
     * @param clazz
     * @param expire 秒
     * @return
     */
    public Set<String>  getKeys(String key) {
    	try {
    		Set<String> keys =redisTemplate.keys(key);
        	return keys;
    	} catch (Exception e) {
    		logger.error("Reis获取数据[key="+key+"]异常:["+e+"]");
		}
    	return null;
    }
    
    /**
     * 存储hash值
     * @param key
     * @param clazz
     * @param expire 秒
     * @return
     */
    public void  putHash(String key, String hashKey, String value){
    	try {
    		redisTemplate.opsForHash().put(key,hashKey, value);
    	} catch (Exception e) {
    		logger.error("Reis存储hash数据[key="+key+"]异常:["+e+"]");
		}
    }
    
    /**
     * 存储key  value值
     * @param key
     * @param value
     */
    public void putAll(String key, Map<Object, Object> value) {
    	try {
    		redisTemplate.opsForHash().putAll(key, value);
    	} catch (Exception e) {
    		logger.error("Reis存储hash数据[key="+key+"]异常:["+e+"]");
		}
    }
    
    /**
     * 根据key和hashkey 获取对象
     * @param key
     * @param clazz
     * @param expire 秒
     * @return
     */
    public Object  getHash(String key,  Object hashKey){
    	Object hashValue=null;
    	try {
    		hashValue=redisTemplate.opsForHash().get(key,hashKey);
    	} catch (Exception e) {
    		logger.error("Reis获取hash数据[key="+key+"]异常:["+e+"]");
		}
    	return hashValue;
    }
    
    /**
     * 根据key 返回map集合
     * @param key
     * @param clazz
     * @param expire 秒
     * @return
     */
    public Map<Object,Object>  entries(String key){
    	Map<Object,Object> hashValue=null;
    	try {
    		hashValue=redisTemplate.opsForHash().entries(key);
    	} catch (Exception e) {
    		logger.error("Reis获取map数据[key="+key+"]异常:["+e+"]");
		}
    	return hashValue;
    }
    
    /**
     * 递增
     * @param key 键
//     * @param by 要增加几(大于0)
     * @return
     */
    public long increment(String key,String hashKey, long delta){
        if(delta<0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForHash().increment(key,hashKey, delta);
    }
    
    /**
     * 根据key和hashkey 删除对象
     * @param key
     * @param clazz
     * @param expire 秒
     * @return
     */
    public Object  delHash(String key,  Object hashKey){
    	Object hashValue=null;
    	try {
    		hashValue=redisTemplate.opsForHash().delete(key, hashKey);
    	} catch (Exception e) {
    		logger.error("Reis删除hash数据[key="+key+"]异常:["+e+"]");
		}
    	return hashValue;
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }
    
    /**
     * 数据获取
     * @param key
     * @param expire 秒
     * @return
     */
    public String get(String key, long expire) {
    	try {
    		String value = (String)redisTemplate.opsForValue().get(key);
    		if(expire != NOT_EXPIRE){
    			redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        	}
        	return value;
    	} catch (Exception e) {
    		logger.error("Reis获取数据[key="+key+"]异常:["+e+"]");
		}
    	return null;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
    
    public void deleteKeys(String key) {
    	Set<String> keys = redisTemplate.keys(key);
        redisTemplate.delete(keys);
    }
    
    public void deleteHash(String key) {
        redisTemplate.opsForHash().delete(key);
    }


    /**
     * Object转成JSON数据
     */
    public String toJson(Object object){
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    public <T> T fromJson(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }
    
    public String hgetData(String key,String field) {
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
		return boundHashOperations.get(field);
	}
    
    public void hsetData(String key,String field, String value) {
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
		boundHashOperations.put(field, value);
	}

	public void hmsetData(String key,Map<String,String> fields) {
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
		boundHashOperations.putAll(fields);
	}
	public Map<String,String> hmgetData(String key) {
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
		return boundHashOperations.entries();
	}

	public Boolean setnx(final String key,final String value,int timeOut) {
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		Boolean success= opsForValue.setIfAbsent(key, value);
		if(success != null && success){
			redisTemplate.expire(key,timeOut,TimeUnit.MILLISECONDS);
			return true;
		}
		return false;
	}
	
	public Boolean setnx(final String key,final String value) {
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		Boolean success= opsForValue.setIfAbsent(key, value);
		if(success != null && success){
			redisTemplate.expire(key,300,TimeUnit.MILLISECONDS);
			return true;
		}
		return false;
	}
	
	public String getData(String key) {
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		String serializable = (String) opsForValue.get(key);
		return serializable;
	}
	
	public void setData(String key, String value) {
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		opsForValue.set(key, value);
	}
	
	public void setData(String key, String value, long time, TimeUnit timeUnit) {
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		opsForValue.set(key, value, time, timeUnit);
	}
	
	public void deleteKey(final String key){
		if(!StringUtils.isBlank(key)){
			redisTemplate.delete(key);
		}
	}
	
	public void setListValue(String key, List<String> list) {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		opsForList.rightPushAll(key, list);
	}
	
	public void setObjListValue(String key, List<Object> list) {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		opsForList.rightPushAll(key, list);
	}
	
	public boolean hasKey(String key){
		if(StringUtils.isBlank(key)){
			return false;
		}
		return redisTemplate.hasKey(key);
	}
	
	public List<Object> getListValues(String key) {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		return opsForList.range(key, 0, -1);
	}
	
	public void pushListValue(String key, String value) {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		opsForList.rightPush(key, value);
	}

	public void removeListValue(String key, String value) {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		opsForList.remove(key, -1, value);
	}

	public Boolean expire(String key, final long timeout, final TimeUnit unit) {
		return redisTemplate.expire(key, timeout, unit);
	}

	public void removeUntreatedOrder(String key, String orderNo) {
		redisTemplate.opsForHash().delete(key, orderNo);
	}

	public boolean permanentLock(String owner, String lockKey) {

        String code = "" + lockKey;
        return (Boolean) redisTemplate.execute((RedisCallback<?>) connection -> connection.setNX(code.getBytes(), owner.getBytes()));
    }

    public boolean tryPermanentLock(String owner, String lockKey) {
        while (true) {
            if (permanentLock(owner, lockKey)) {
                return true;
            }

            try {
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                logger.error("线程休眠异常!", e.getMessage());
            }
        }
    }
    
    public boolean lock(String owner, String lockKey) {
        return lock(owner, lockKey, 500L);
    }

    public boolean lock(String owner, String lockKey, Long expiration) {
        String code = "" + lockKey;
        return (Boolean) redisTemplate.execute((RedisCallback<?>) connection -> {

            Boolean acquire = connection.setNX(code.getBytes(), owner.getBytes());
            if (acquire) {
                connection.setEx(code.getBytes(), expiration, owner.getBytes());
                return true;
            } else {
                return false;
            }

        });

    }
    
    public boolean tryLock(String owner, String lockKey) {
        return tryLock(owner, lockKey, 500L);
    }

    public boolean tryLock(String owner, String lockKey, Long expiration) {
        int count = 0;
        while (true) {

            if (lock(owner, lockKey, expiration)) {
                return true;
            }

            if (count > 30) {
                logger.info("redis 获取锁等待超时,所有者:{},锁定key:{}", owner, lockKey);
                return false;
            }
            count++;

            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                logger.error("线程休眠异常!", e.getMessage());
            }
        }
    }
    
	public boolean unLock(String owner, String lockKey) {
        String code = "" + lockKey;

        return (Boolean) redisTemplate.execute((RedisCallback<?>) connection -> {
            byte[] ownerByte = connection.get(code.getBytes());
            if (ownerByte == null) {
                return true;
            }
            String lockOwner = new String(ownerByte);
            if (StringUtils.equals(owner, lockOwner)) {
                connection.del(code.getBytes());
                return true;
            } else {
                return false;
            }
        });
    }

	public Map<Object, Object> getEntries(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	public void removeSetValue(String key, Object... value) {
		SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();
		opsForSet.remove(key, value);
	}
}
