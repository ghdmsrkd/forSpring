package kr.inhatc.spring.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.course.entity.Course;
import kr.inhatc.spring.course.repository.CourseRepository;
import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.repository.LectureRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public void saveCourse(Course course) {
		courseRepository.save(course);	
	}



	@Override
	public Course getCourse(Long id) {
		
		Optional<Course> optional = courseRepository.findById(id);
		if(optional.isPresent()) {
			Course course = optional.get();
			return course;
		}else
		{
			throw new NullPointerException("******we dont have any course what you want. sorry!!***********");
		}
		
	}



	@Override
	public List<Course> getListCourse() {
		List<Course> course = (List<Course>) courseRepository.findAll(); 
		return course;
	}

	

	@Override 
	public List<Course> getListCourseByUser(String id) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++id"+ id);
		List<Course> course = courseRepository.findAllByUser(id);
		return course;

	}



	@Override
	public List<Course> getCourseListByTake(String id) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++id"+ id);
		List<Course> course = courseRepository.findAllByTake(id);
		return course;
	}



	@Override
	public List<Course> getCourseListByRownum(int row) {
		List<Course> course = courseRepository.findAllByRownum(row);
		return course;
	}



	
	
}
