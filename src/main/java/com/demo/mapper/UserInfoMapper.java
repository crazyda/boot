package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.demo.entity.User;

@Mapper
public interface UserInfoMapper {
	
	@Select("select * from user where login = #{login}")
	User findOneByLogin(String login);

}
