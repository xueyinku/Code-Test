package com.xue.customer.service;

import com.xue.custom.model.Admin;

public interface AdminService {
	Admin select(Admin admin);
	boolean addAdmin(Admin admin);
}
