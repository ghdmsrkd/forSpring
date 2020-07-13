package kr.inhatc.spring.take.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.take.entity.Take;
import kr.inhatc.spring.take.repository.TakeRepository;

@Service
public class TakeServiceImpl implements TakeService {
	
	@Autowired
	private TakeRepository takeRepository;
	
	@Override
	public void saveTake(Take take) {
		takeRepository.save(take);
		
	}

	@Override
	public List<Take> getTakeListByUser(String id) {
		
		List<Take> take = takeRepository.findAllByUser(id);
		return take;
	}

}
