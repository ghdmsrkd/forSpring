package kr.inhatc.spring.user.service;

import java.util.List;

import kr.inhatc.spring.user.entity.Users;

public interface UserService {

	List<Users> userList();

	void saveUsers(Users user);

	Users userDtail(String id);

	void userDelete(String id);

}