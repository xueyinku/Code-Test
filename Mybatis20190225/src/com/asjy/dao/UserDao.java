package com.asjy.dao;

import org.apache.ibatis.annotations.Select;

import com.asjy.model.User;

public interface UserDao {

	//����ĵ�½��֤������
	@Select("select user_id id, user_name name, user_password password, user_job job, user_salary salary from tbl_user where user_name = #{name} and user_password = #{password}")
	User login(User user);
}




