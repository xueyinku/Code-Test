package com.asjy.service;

import java.util.List;

import com.asjy.model.UserPermission;

public interface UserPermissionService {

	//根据用户id查询中间表数据
	List<UserPermission> findByUserId(int userId);
}
