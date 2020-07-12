package com.xue.dao;

import org.apache.ibatis.annotations.Select;

import com.xue.model.User;

public interface UserDao {
	
	@Select("select no,id,password,level from tbl_book_user where id = #{id} and password = #{password}")
	User selecUser(User user);
}
