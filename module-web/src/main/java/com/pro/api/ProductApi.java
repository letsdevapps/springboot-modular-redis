package com.pro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

	@Autowired
	private ProductService productService;

	@GetMapping({ "", "/" })
	public ResponseEntity<String> getProductById() {
		String prdouctInfo = productService.getProductInfo();
		return ResponseEntity.ok(prdouctInfo);
	}

	@GetMapping("/redis/get")
	public ResponseEntity<String> getRedisKey(@RequestParam String key) {
		String valueFromRedis = productService.getRedisKey(key);
		return ResponseEntity.ok("Value get Redis for key '" + key + "': " + valueFromRedis);
	}

	@PostMapping("/redis/set")
	public ResponseEntity<String> setRedisKey(@RequestParam String key, @RequestParam String value) {
		productService.setRedisKey(key, value);
		return ResponseEntity.ok("Value set Redis for key '" + key + "': " + value);
	}
}