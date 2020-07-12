package com.xue.dao;

import java.util.List;

import com.xue.model.Actor;
import com.xue.model.Movie;

public interface ActorDao {
	List<Actor> selectByName(String name);//根据演员名称，看到演员所有信息  本质上一对一
}
