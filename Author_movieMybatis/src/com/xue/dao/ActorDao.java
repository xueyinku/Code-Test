package com.xue.dao;

import java.util.List;

import com.xue.model.Actor;
import com.xue.model.Movie;

public interface ActorDao {
	List<Actor> selectByName(String name);//������Ա���ƣ�������Ա������Ϣ  ������һ��һ
}
