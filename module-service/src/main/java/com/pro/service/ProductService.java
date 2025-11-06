package com.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private RedisService redisService;

	public String getProductInfo() {
		return "This is product information from ProductService.";
	}

	public String getRedisKey(String key) {
		return redisService.get(key);
	}

	public void setRedisKey(String key, String value) {
		redisService.set(key, value);
	}
}
