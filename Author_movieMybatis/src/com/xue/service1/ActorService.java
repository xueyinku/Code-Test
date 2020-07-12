package com.xue.service1;

import java.util.List;

import com.xue.model.Actor;

public interface ActorService {
	List<Actor> selectActorByname(String name);//根据演员名称，查看演员信息，包含参演电影信息
}
