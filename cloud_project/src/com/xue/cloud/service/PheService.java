package com.xue.cloud.service;

import java.util.List;

import com.xue.cloud.model.Phenomenon;

public interface PheService {
	List<Phenomenon> selectAll();//查找所有现象类型
}
