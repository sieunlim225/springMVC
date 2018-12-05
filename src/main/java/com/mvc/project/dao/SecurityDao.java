package com.mvc.project.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.project.springsecurity.CustomUserDetail;

@Mapper
public interface SecurityDao {

	CustomUserDetail getUserById(String username);

}
