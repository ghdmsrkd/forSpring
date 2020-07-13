package kr.inhatc.spring.login.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import kr.inhatc.spring.user.entity.Users;
import lombok.Getter;

public class SecurityUser extends User {
	
	@Getter
	private Users user;
	
	public SecurityUser(Users user) {
		
		// 암호화 처리 전까지는 페스워드 앞에 {noop} 를 추가해야한다
		super(
				user.getId(), 
				user.getPw(), 
				AuthorityUtils.createAuthorityList(user.getRole())
				);
		//System.out.println("+++++++++++++++++++SecurityUser"+user.getEmail());
		this.user = user;
	}



}
