package com.asjy.service.impl;

import java.util.List;

import com.asjy.dao.PermissionDao;
import com.asjy.model.Permission;
import com.asjy.service.PermissionService;

public class PermissionServiceImpl implements PermissionService{

	@Override
	public List<Permission> findPermission() {
		// TODO 查询所有权限
		String sql = "select * from tbl_permission";
		return PermissionDao.query(sql);
	}

}
