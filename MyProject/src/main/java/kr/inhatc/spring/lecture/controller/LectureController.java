package kr.inhatc.spring.lecture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.service.LectureService;
import kr.inhatc.spring.user.entity.Users;



@Controller
public class LectureController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LectureService lectureService;	
	
	@RequestMapping("lecture")
	public String index() {

		return "lecture/index";
	}
	
	@RequestMapping("lecture/saidaVideo")
	public String saidaVideo() {

		return "lecture/saidaVideo";
	}
	
	@RequestMapping("lecture/saidaLogin")
	public String saidaLogin() {

		return "lecture/saidaLogin";
	}
	
	@RequestMapping("lecture/saidaSignUp")
	public String saidaSignUp() {

		return "lecture/saidaSignUp";
	}
	
	@RequestMapping("lecture/lectureRegistForm")
	public String lectureRegist() {

		return "lecture/lectureRegist";
	}
	
	@RequestMapping(value = "lecture/lectureRegist", method=RequestMethod.POST)
	public String lectureRegist(Lecture lecture) {
		//System.out.println("lecture.getLecContent() : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture.getLecTitle());
		//System.out.println("lecture.getLecContent() : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture.getLecContent());
		
		lectureService.saveLecture(lecture);
		return "lecture/lectureRegist";
	}
	
	
	
	
	@RequestMapping(value= "/lecture/lectureShow",method=RequestMethod.GET)
	public String userList(Model model ) {


		return "lecture/test";
	} 
	
	@RequestMapping(value= "/lecture/lectureShow/{id}",method=RequestMethod.GET)
	public String lectureShow(@PathVariable("id") Long id, Model model) {
		Lecture lecture = lectureService.lectureShow(id);
		model.addAttribute("lecture", lecture);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture);
		return "lecture/lectureShow";
	} 
	
	
	
	
	
	
	@RequestMapping("lecture/test")
	public String test() {

		return "lecture/test";
	}
}
