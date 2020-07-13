package kr.inhatc.spring.take.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.service.CourseService;
import kr.inhatc.spring.lecture.service.LectureService;
import kr.inhatc.spring.login.security.SecurityUser;
import kr.inhatc.spring.take.entity.Take;
import kr.inhatc.spring.take.service.TakeService;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;

@Controller
public class TakeController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LectureService lectureService;	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TakeService takeService;
	
	@RequestMapping(value = "take/takeCourse/{id}", method = RequestMethod.GET)
	public String takeCourse(@PathVariable("id") Long id, 
			@AuthenticationPrincipal SecurityUser principal, Model model) {
		
		Users user = userService.userDtail(principal.getUsername());
		Course course = courseService.getCourse(id);
		
		Take take = new Take();	
		take.setUser(user);
		take.setCourse(course);	
		user.addTake(take);
		course.addTake(take);
		takeService.saveTake(take);
			
		model.addAttribute("courseId", id);
		return "redirect:/course/courseList/all";
	}
	
	
	
	
	
	
	
	
}
