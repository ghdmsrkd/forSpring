package kr.inhatc.spring.take.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.lecture.entity.Lecture;
import kr.inhatc.spring.take.entity.Take;

@Repository
public interface TakeRepository extends CrudRepository<Take, Long> {
	
	@Query(value = "select * from take where id = ?1", nativeQuery = true)
	List<Take> findAllByUser(String id);
 
}
