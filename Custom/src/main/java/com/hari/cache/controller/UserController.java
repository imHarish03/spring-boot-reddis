package com.hari.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hari.cache.model.User;
import com.hari.cache.redis.RedisUtility;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RedisUtility redisUtility;

	@PostMapping()
	public User saveUserInfo(@RequestBody User use) {

		try {
			redisUtility.setValue(use.getUserName(), use.getFullName());
		} catch (Exception e) {
			System.out.println(e);
		}

		return use;
	}

	@GetMapping()
	public String getUserInfo(@RequestParam(value = "key") String key) {

		try {
			return redisUtility.get(key);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "Test Data";
	}

}
