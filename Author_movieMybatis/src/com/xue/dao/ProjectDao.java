package com.xue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.model.Project;

public interface ProjectDao {
	List<Project> selectDynamic(@Param("startMes") int startMes,@Param("endMes") int endMes,@Param("name") String name);
}
