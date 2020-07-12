package com.xue.service1;

import com.xue.model.ProjectByPage;

public interface ProjectService {
	ProjectByPage selectByNameAndPage(int currentpage,String name);
}
