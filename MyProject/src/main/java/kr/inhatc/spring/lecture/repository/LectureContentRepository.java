package kr.inhatc.spring.lecture.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.entity.LectureContent;

public interface LectureContentRepository extends CrudRepository<LectureContent, Long>{
	@Query(value = "SELECT * FROM LECTURE_CONTENT WHERE lec_id = ?1", nativeQuery = true)
	LectureContent findByLectureId(Long id);
}
