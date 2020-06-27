package kr.inhatc.spring.lecture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.service.CourseService;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.entity.LectureContent;
import kr.inhatc.spring.lecture.service.LectureService;
import kr.inhatc.spring.login.security.SecurityUser;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;



@Controller
public class LectureController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LectureService lectureService;	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/lecture/")
	public String index( @AuthenticationPrincipal SecurityUser priciUser, Model model) {
		List<Course> course =  courseService.getCourseListByRownum(4);
		model.addAttribute("course", course);
		System.out.println("++++++++++++++++++++++++++++ 여기까지는 된당");
		return "lecture/index";
		
		
	}
	
	@RequestMapping(value = "lecture/lectureRegistForm/{id}", method = RequestMethod.GET)
	public String lectureRegist(@PathVariable("id") Long id, Model model) {
		model.addAttribute("courseId", id);
		//System.out.println("++++++++++++++++++"+id);
		return "lecture/lectureRegist";
	}
	
	@RequestMapping(value = "lecture/lectureRegist", method=RequestMethod.POST)
	public String lectureRegist(Lecture lecture, LectureContent lectureContent, Model model) {
		
		Long id = lecture.getCourse().getCouId(); 
		Course course = courseService.getCourse(id);
		
		lecture.setCourse(course);	
		course.addLecture(lecture);
		lectureContent.setLecture(lecture);
		
		//System.out.println("+++++++++++++++++++++++lectureContent"+lectureContent.getLecContent());
		
		lectureService.saveLecture(lecture);
		lectureService.saveLectureContent(lectureContent);
		//model.addAttribute("courseId", course.getCouId());
		return "redirect:lectureList/"+course.getCouId();
	}
	
	@RequestMapping(value= "/lecture/lectureShow/{id}",method=RequestMethod.GET)
	public String lectureShow(@PathVariable("id") Long id, Model model) {
		
		Lecture lecture = lectureService.lectureShow(id);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture.getCourse().getCouId());
		List<Lecture> lectureList = lectureService.getListLectureByCourse(lecture.getCourse().getCouId());
		LectureContent lectureContent = lectureService.lectureContentShow(id);
		model.addAttribute("lecture", lecture);
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("lectureContent", lectureContent);
		return "lecture/lectureShow";
	} 

	@RequestMapping("/lecture/courseRegist")
	public String test() {

		return "lecture/test";
	}
	
	@RequestMapping(value = "lecture/lectureList/{id}", method=RequestMethod.GET)
	public String courseList(@PathVariable("id") Long id, Model model) {
		if(id == 0) { // 전체 강의 리스트 <== 나중에 전체 리스트가 관리가 필요시 작성 (x) 
			//List<Lecture> lecture = lectureService.getListLecture();
			//model.addAttribute("lecture", lecture);
			//model.addAttribute("courseId", id);
			return "lecture/lectureList";
		} else { // 특정 강좌의 강의 리스트
			System.out.println("++++++++++++++++++++++++ id"+id);
			List<Lecture> lecture = lectureService.getListLectureByCourse(id);
			//System.out.println("++++++++++++++++++++++++ lecture1"+lecture.get(0).getLecTitle());
			model.addAttribute("lecture", lecture);
			model.addAttribute("courseId", id);
			return "lecture/lectureList";
		}
		
	}
	
	
	
	
	
	
}
