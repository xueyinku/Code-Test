package com.xue.service;

import org.apache.ibatis.annotations.Select;

import com.xue.model.User;

public interface UserServcice {
	//根据user是否存在
	User selectUser(User user);

}
