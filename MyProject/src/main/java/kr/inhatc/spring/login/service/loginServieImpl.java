package kr.inhatc.spring.login.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;

public class loginServieImpl implements loginService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveUsers(Users user) {
		userRepository.save(user);
		
	}
}
