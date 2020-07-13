package kr.inhatc.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// 관한에 따른 사용자 접근 경로
		
		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/user/**").hasAnyRole("ADMIN");
		security.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN");
		security.authorizeRequests().antMatchers("/lecture/lectureRegist**").hasAnyRole("ADMIN", "TEACHER");
		security.authorizeRequests().antMatchers("/lecture/lectureShow/**", "/course/**").hasAnyRole("ADMIN", "TEACHER", "STUDENT");
		
		// 페이지 위조 요청
		security.csrf().disable();
		
		//로그인 관련 페이지와 성공시 이동할 페이지 설정
		security.formLogin()
			.loginPage("/login/login")
			.defaultSuccessUrl("/lecture/", true);
		
		//로그인 실패시 이용 페이지
		security.exceptionHandling().accessDeniedPage("/login/accessDenied");
		
		//로그아웃 요청시 세션을 강제종료하고 시작 페이지로 이동
		security.logout().logoutUrl("/login/logout").invalidateHttpSession(true).logoutSuccessUrl("/lecture/");
		
		
		
	}
	
	// 개요 : 페스워드의 암호화 처리
	// 처리내용 암호화 처리
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// 개요 : sec:authorize
	// 
//	@Bean
//    public SpringSecurityDialect springSecurityDialect(){
//        return new SpringSecurityDialect();
//    }
	
}
