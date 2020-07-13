package kr.inhatc.spring.course.service;

import java.util.List;

import kr.inhatc.spring.course.entity.Course;

public interface CourseService {
	void saveCourse(Course course);
	
	Course getCourse(Long id);
	
	List<Course> getListCourse();
	
	List<Course> getListCourseByUser(String id);

	List<Course> getCourseListByTake(String id);
	
	List<Course> getCourseListByRownum(int row);
}
