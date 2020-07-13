package kr.inhatc.spring.course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.course.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	Optional<Course> findById(Long id);
	
	@Query(value = "select * from course c where c.id = ?1", nativeQuery = true)
	List<Course> findAllByUser(String id);
	
	@Query(value = "select * from course c where c.id = ?1", nativeQuery = true)
	List<Course> findAllByTake(String id);
	
	@Query(value = "SELECT * FROM ( SELECT * FROM course ORDER BY cou_id) WHERE ROWNUM <= 4", nativeQuery = true )
	List<Course> findAllByRownum(int row);
	
	//List<Course> findAllByid(String id);

	//List<Course> findBy_User_id(String id);
}
