package com.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// Armazenar valor no Redis
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	// Recuperar valor do Redis
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	// Deletar valor do Redis
	public void delete(String key) {
		redisTemplate.delete(key);
	}
}