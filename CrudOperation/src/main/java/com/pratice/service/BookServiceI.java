package com.pratice.service;

import java.util.Map;

import com.pratice.entity.Book;

public interface BookServiceI {

	Book postBook(Book entity);

	Book getBookById(Integer id);

	Book updateBookDetails(Integer id, Book entity);

	Book updatePartialData(Integer id, Map<String, Object> jsonData);

	void deleteBookById(Integer id);

}
