package com.asjy.dao;

import org.apache.ibatis.annotations.Select;

import com.asjy.model.User;

public interface UserDao {

	//����ӿ�
	
	//����ĵ�½��֤����
	@Select("select no, id, password, level from user where id = #{id} and password = #{password}")
	User login(User user);
}
