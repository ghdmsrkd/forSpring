package kr.inhatc.spring.take.service;

import java.util.List;

import kr.inhatc.spring.take.entity.Take;

public interface TakeService {
	void saveTake(Take take);

	List<Take> getTakeListByUser(String id);
	
}
