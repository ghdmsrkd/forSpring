package kr.inhatc.spring.lecture.service;

import java.util.List;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.entity.LectureContent;
import kr.inhatc.spring.user.entity.Users;

public interface LectureService {
	

	void saveLecture(Lecture lecture);
	
	Lecture lectureShow(Long id);

	List<Lecture> getListLecture();

	List<Lecture> getListLectureByCourse(Long id);
	
	
	/* 강의 내용 관련 함수 */
	LectureContent lectureContentShow(Long id);
	
	void saveLectureContent(LectureContent lectureContent);
}
