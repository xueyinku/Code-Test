package com.asjy.dao;

import com.asjy.model.Permission;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PermissionDao {

	//代理的鉴权方法
	List<Permission> findPermissionByUserId(@Param("userId") int userId);
}


