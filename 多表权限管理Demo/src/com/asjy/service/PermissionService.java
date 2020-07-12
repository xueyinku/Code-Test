package com.asjy.service;

import java.util.List;

import com.asjy.model.Permission;

public interface PermissionService {

	//查询所有权限
	List<Permission> findPermission();
}
