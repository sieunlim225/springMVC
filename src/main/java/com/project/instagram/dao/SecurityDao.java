package com.project.instagram.dao;

import org.apache.ibatis.annotations.Mapper;

import com.project.instagram.springSecurity.CustomUserDetail;

@Mapper
public interface SecurityDao {

	CustomUserDetail getUserById(String username);

}
