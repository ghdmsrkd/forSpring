package kr.inhatc.spring.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver comCommonsMultipartResolver = new CommonsMultipartResolver();
		comCommonsMultipartResolver.setDefaultEncoding("UTF-8");
		comCommonsMultipartResolver.setMaxUploadSizePerFile(5*1024*1024); //5MB
		return comCommonsMultipartResolver;
	}
}
