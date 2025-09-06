package com.usermanagement.service;

import com.usermanagement.model.User;
import com.usermanagement.repository.UserRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User addUser(User newUser) {
		return this.userRepository.save(newUser);
	}

	public List<User> getUserList() {
		return this.userRepository.findAll();
	}

	public String deleteUser(Long userId) {
		if(this.userRepository.findById(userId).isPresent()) {
			this.userRepository.deleteById(userId);
			return "user deleted";
		}else {
			return userId.toString() + " isn't in user list";
		}
	}

	public User updateUser(Long userId, User newUserInfo) {
		if(this.userRepository.findById(userId).isPresent()) {
			User userInfo = this.userRepository.findById(userId).get();
			userInfo.setName(newUserInfo.getName());
			userInfo.setSurname(newUserInfo.getSurname());
			userInfo.setAdress(newUserInfo.getAdress());
			userInfo.setAge(newUserInfo.getAge());
			return this.userRepository.save(userInfo);
		}else {
			throw new ELException(userId.toString() + " isn't in user list");
		}
	}
}
