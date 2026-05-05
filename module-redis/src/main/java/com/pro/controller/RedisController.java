package com.pro.controller;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

  @Autowired
  private RedisConnectionFactory connectionFactory;

	@Autowired
	private RedisService redisService;

	@PostMapping("/set")
	public String setValue(@RequestParam String key, @RequestParam String value) {
		redisService.set(key, value);
		return "Valor salvo no Redis!";
	}

	@GetMapping("/get")
	public String getValue(@RequestParam String key) {
		return redisService.get(key);
	}

	@DeleteMapping("/delete")
	public String deleteValue(@RequestParam String key) {
		redisService.delete(key);
		return "Valor deletado do Redis!";
	}
	
	@GetMapping("/redis-status")
  public boolean isRedisUp() {
      try (RedisConnection connection = connectionFactory.getConnection()) {
          return "PONG".equals(connection.ping());
      } catch (Exception e) {
          return false;
      }
  }
}
