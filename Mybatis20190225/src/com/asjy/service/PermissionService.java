package com.asjy.service;

import java.util.List;

import com.asjy.model.Permission;

public interface PermissionService {

	//����user_id��ѯȨ�޵ķ���
	List<Permission> findPermissionByUserId(int userId);
}
