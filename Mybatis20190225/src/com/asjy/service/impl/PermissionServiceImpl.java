package com.asjy.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.asjy.dao.PermissionDao;
import com.asjy.model.Permission;
import com.asjy.service.PermissionService;
import com.asjy.util.MybatisUtil;

public class PermissionServiceImpl implements PermissionService{

	@Override
	public List<Permission> findPermissionByUserId(int userId) {
		// TODO ���ó־ò��еĴ����Ȩ����
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		
		PermissionDao mapper = sqlsession.getMapper(PermissionDao.class);
		
		List<Permission> permissionList = mapper.findPermissionByUserId(userId);
		
		sqlsession.close();
		
		return permissionList;
	}

}
