package com.xue.book.service;

import com.xue.book.model.BookUser;

public interface BookUserService {
	BookUser select(BookUser bookuser);
	boolean insert(BookUser bookuser);
}
