package kr.inhatc.spring.course.controller;

import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.service.CourseService;
import kr.inhatc.spring.login.security.SecurityUser;
import kr.inhatc.spring.take.entity.Take;
import kr.inhatc.spring.take.service.TakeService;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;


@Controller
public class CourseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseService courseService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private TakeService takeService;
	
	@RequestMapping(value = "course/courseRegist", method=RequestMethod.POST)
	public String courseRegist(@AuthenticationPrincipal SecurityUser priciUser, Course course) {
		Users user = userService.userDtail(priciUser.getUsername());
		
		course.setUser(user);
		user.addCourse(course);
		
		courseService.saveCourse(course);
		return "redirect:courseMyList/";
	}
	
	@RequestMapping(value = "course/courseRegistForm/{id}", method = RequestMethod.GET)
	public String courseRegistForm(@PathVariable("id") String id, Model model) {
		model.addAttribute("userId", id);
		
		
		return "course/courseRegist";
	}
	
	@RequestMapping(value = "course/courseList/{id}", method=RequestMethod.GET)
	public String courseList(@PathVariable("id") String id, Model model) {
		
		if(id.equals("all")) { //전체 강좌 리스트
			List<Course> course = courseService.getListCourse();
			model.addAttribute("course", course);
			//model.addAttribute("courseId", id);
			return "course/courseList";
		} else {
			//System.out.println("+++++++++++++++++++++++++++++++++++++id == "+id);
			List<Course> course = courseService.getListCourseByUser(id);
			//System.out.println("+++++++++++++++++++++++++++++++++++++course"+course.get(0).getCouTitle());
			//model.addAttribute("courseId", id);
			model.addAttribute("course", course);
			return "course/courseList";
		}
		
	}
	
	@RequestMapping(value = "course/courseMyList")
	public String courseMyList(@AuthenticationPrincipal SecurityUser principal, Model model) {
		
		if(principal !=null) {
			String user = principal.getUsername();
			String role = principal.getAuthorities().toString();
			//System.out.println("++++++++++++++++++++++++++++++username"+user);
			//System.out.println("++++++++++++++++++++++++++++++principal.getAuthorities()"+principal.getAuthorities());
			if(role.equals("[ROLE_TEACHER]")) {
				System.out.println("++++++++++++++++++++++++++++++++++++++++ 강사의 MY LIST");
				List<Course> course = courseService.getListCourseByUser(user);
				model.addAttribute("course", course);
				model.addAttribute("userId", principal.getUsername());
				
				//System.out.println("+++++++++++++++++++++++++++++++++course"+course.size());
				return "course/courseList";
				
			} else if (role.equals("[ROLE_STUDENT]")) {
				//수강 테이블 만든후 작성한다.
				System.out.println("++++++++++++++++++++++++++++++++++++++++ 학생의 MY LIST");
				List<Take> take = takeService.getTakeListByUser(user);
				if(take.isEmpty()) {
					
				} else {
					//System.out.println("++++++++++++++++++++++++++++++++++++++++ 캐스트 안됨 ㄷ");
					List<Course> course =  new ArrayList<Course>();
					
					for(Take t : take) {
						course.add(t.getCourse());
						System.out.println("++++++++++++++"+ t.getCourse().getCouTitle());
					}
					model.addAttribute("course", course);
					model.addAttribute("userId", principal.getUsername());
				}
				

				return "course/courseList";
				
			}
		}
		
		
		return "login/login";
	}
	
	
	
	
	
	
	
	
}
