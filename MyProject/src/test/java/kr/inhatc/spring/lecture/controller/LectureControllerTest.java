package kr.inhatc.spring.lecture.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.repository.CourseRepository;
import kr.inhatc.spring.course.service.CourseService;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.repository.LectureRepository;
import kr.inhatc.spring.lecture.service.LectureService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LectureControllerTest {

	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	LectureService lectureService;
	
	@Autowired
	LectureRepository lectureRepository;
	
	@Test
	void test() {
		/*
		Course c = new Course();
		c.setCouOutline("개요1");
		c.setCouTitle("강좌 제목1");
		courseService.saveCourse(c);
		*/
		Course c = courseService.getCourse(9L);
		
		Lecture l = new Lecture();
		l.setLecContent("BBB");
		l.setLecTitle("BBB");
		l.setCourse(c);							
		
		c.addLecture(l);		
		lectureService.saveLecture(l);
	}

}
