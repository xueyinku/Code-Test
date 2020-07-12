package com.asjy.service.impl;

import java.util.List;

import com.asjy.dao.UserPermissionDao;
import com.asjy.model.UserPermission;
import com.asjy.service.UserPermissionService;

public class UserPermissionServiceImpl implements UserPermissionService{

	@Override
	public List<UserPermission> findByUserId(int userId) {
		// TODO �����û�id��ѯ�м������
		String sql = "select * from tbl_userpermission where user_id = ?";
		List<UserPermission> list = UserPermissionDao.query(sql, userId);
		return list;
	}

}
