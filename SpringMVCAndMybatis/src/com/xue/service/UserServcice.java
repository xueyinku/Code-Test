package com.xue.service;

import org.apache.ibatis.annotations.Select;

import com.xue.model.User;

public interface UserServcice {
	//����user�Ƿ����
	User selectUser(User user);

}
