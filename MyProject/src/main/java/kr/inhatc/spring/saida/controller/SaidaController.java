package kr.inhatc.spring.saida.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SaidaController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("saida")
	public String index() {

		return "saida/index";
	}
	
	@RequestMapping("saida/saidaVideo")
	public String saidaVideo() {

		return "saida/saidaVideo";
	}
	
	@RequestMapping("saida/saidaLogin")
	public String saidaLogin() {

		return "saida/saidaLogin";
	}
	
	@RequestMapping("saida/saidaSignUp")
	public String saidaSignUp() {

		return "saida/saidaSignUp";
	}
}
