package kr.inhatc.spring.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.user.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {
	List<Users> findAllByOrderByIdDesc();

	List<Users> findAllByRole(String role);

	
}
