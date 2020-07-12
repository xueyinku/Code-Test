package com.asjy.service;

import java.util.List;

import com.asjy.model.Permission;

public interface PermissionService {

	//根据user_id查询权限的方法
	List<Permission> findPermissionByUserId(int userId);
}
