package kr.inhatc.spring.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login/login")
	public void login() {
		log.debug("Login Test중");
		
		
	}
	
	@GetMapping("/login/accessDenied")
	public void accessDenied() {
		
	}
	
	@GetMapping("login/logout")
	public void logout() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 로그아웃");
	}
	
	@GetMapping("login/signupForm")
	public String signupForm() {
		
		
		return "login/signup";
	}
	
	@PostMapping("login/signup")
	public String signup(Users user) {
		if(user != null) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> 페스워드 인코딩 전" + user.getPw());
			String pw = encoder.encode(user.getPw());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> 페스워드 인코딩 후" + pw);
			user.setPw(pw);
			System.out.println("유저 가입 : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+user.getName());
			userService.saveUsers(user);
		}
		return "redirect:/lecture/";
	}
	
	
	
	
}
