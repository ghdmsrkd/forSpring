package kr.inhatc.spring.lecture.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.entity.LectureContent;
import kr.inhatc.spring.lecture.repository.LectureContentRepository;
import kr.inhatc.spring.lecture.repository.LectureRepository;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	LectureRepository lectureRepository;
	
	@Autowired
	LectureContentRepository lectureContentRepository;
	
	@Override
	public void saveLecture(Lecture lecture) {
		lectureRepository.save(lecture);	
	}

	@Override
	public Lecture lectureShow(Long id) {
		//System.out.println("lectuers ID >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);
		Optional<Lecture> optional = lectureRepository.findById(id);
		if(optional.isPresent()) {
			Lecture lecture = optional.get();
			//System.out.println("lecture >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+lecture);
			return lecture;
		}else
		{
			throw new NullPointerException("******we dont have any lecture what you want. sorry!!***********");
		}
	}

	@Override
	public List<Lecture> getListLecture() {
		List<Lecture> lecture = (List<Lecture>) lectureRepository.findAll();
		return lecture;
	}

	@Override
	public List<Lecture> getListLectureByCourse(Long id) {
		List<Lecture> lecture = lectureRepository.findAllByCourse(id);
		return lecture;
	}
	
	/* 강의 내용 관련 함수 */
	
	@Override
	public LectureContent lectureContentShow(Long id) {
		LectureContent lectureContent = lectureContentRepository.findByLectureId(id);
		return lectureContent;
	}
	
	@Override
	public void saveLectureContent(LectureContent lectureContent) {
		lectureContentRepository.save(lectureContent);
	}

}
