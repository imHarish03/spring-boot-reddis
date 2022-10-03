package com.hari.cache.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUtility {

	@Qualifier("redisTemplate")
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void setValue(String key, String info) {
		redisTemplate.opsForValue().set(key, info);
		redisTemplate.expire(key, 1, TimeUnit.MINUTES);
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}

	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}
