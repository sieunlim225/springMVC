package com.project.instagram.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

	public String gettest();

	public List<String> getList();

	public int insertid();

	
}
