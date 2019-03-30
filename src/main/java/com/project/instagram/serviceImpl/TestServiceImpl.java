package com.project.instagram.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.instagram.dao.TestDao;
import com.project.instagram.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDao testDao;
	
	@Override
	public String test() {
		return testDao.gettest();
	}

	@Override
	public List<String> getList() {
		
		
		return testDao.getList();
	}

	@Override
	public int insertTest() {
		int result = 0;
		try {
			testDao.insertid();
			
			result = testDao.insertid();
			throw new RuntimeException();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
			
		}
		
	}

}
