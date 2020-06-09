package kr.inhatc.spring.saida.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.saida.entity.Lecture;
import kr.inhatc.spring.saida.service.SaidaService;
import kr.inhatc.spring.user.entity.Users;



@Controller
public class SaidaController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SaidaService saidaService;	
	
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
	
	@RequestMapping("saida/saidaRegistLecture")
	public String saidaRegistLecture() {

		return "saida/saidaRegistLecture";
	}
	
	
	
	
	@RequestMapping(value= "/saida/saidaShowLecture",method=RequestMethod.GET)
	public String userList(Model model ) {
		List<Lecture> list = saidaService.lectureList();
		
		System.out.println("content >>>>>>>>>>>>> " + list);
		
		model.addAttribute("list",list);
		return "saida/test";
	} 
	
	@RequestMapping(value= "/saida/saidaShowLecture/{id}",method=RequestMethod.GET)
	public String userDetail(@PathVariable("id") String id, Model model) {
		Lecture lecture = saidaService.lectureDetail(id);
		model.addAttribute("lecture", lecture);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture);
		return "saida/test";
	} 
	
	
	
	
	
	
	@RequestMapping("saida/test")
	public String test() {

		return "saida/test";
	}
}
