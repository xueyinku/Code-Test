package com.asjy.dao;

import com.asjy.model.Permission;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PermissionDao {

	//����ļ�Ȩ����
	List<Permission> findPermissionByUserId(@Param("userId") int userId);
}


