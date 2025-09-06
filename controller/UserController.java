package com.usermanagement.controller;

import java.util.List;

import com.usermanagement.model.User;
import com.usermanagement.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
	final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * use User service
	 */
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User newUser) {
		return ResponseEntity.ok(this.userService.addUser(newUser));
	}

	@GetMapping("/getUserList")
	public ResponseEntity<List<User>> getuserList() {
		return ResponseEntity.ok(this.userService.getUserList());
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		return ResponseEntity.ok(this.userService.deleteUser(userId));
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User newUserInfo) {
		return ResponseEntity.ok(this.userService.updateUser(userId, newUserInfo));
	}
}
