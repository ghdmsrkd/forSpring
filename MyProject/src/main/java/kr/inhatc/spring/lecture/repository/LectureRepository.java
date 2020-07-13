package kr.inhatc.spring.lecture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.lecture.entity.LectureContent;

@Repository 
public interface LectureRepository extends CrudRepository<Lecture, Long> {
	
	Optional<Lecture> findById(Long id);
	
	@Query(value = "select * from lecture  where cou_id = ?1 order by lec_id asc", nativeQuery = true)
	List<Lecture> findAllByCourse(Long id);
	
	
	
	//@Query(value = "SELECT * FROM lectureListExeptContent WHERE cou_id = ?1", nativeQuery = true)
	//List<Lecture> findAllByCourse(Long id);


	
}
