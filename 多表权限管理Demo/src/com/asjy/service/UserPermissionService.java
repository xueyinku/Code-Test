package com.asjy.service;

import java.util.List;

import com.asjy.model.UserPermission;

public interface UserPermissionService {

	//�����û�id��ѯ�м������
	List<UserPermission> findByUserId(int userId);
}
