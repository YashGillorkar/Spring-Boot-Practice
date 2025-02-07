package com.pratice.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.entity.Book;
import com.pratice.exception.InvalidDataFormatException;
import com.pratice.exception.InvalidFieldException;
import com.pratice.exception.InvalidIdException;
import com.pratice.repository.BookRepository;

@Service
public class BookServiceImpl implements BookServiceI {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book postBook(Book entity) {
		return bookRepository.save(entity);
	}

	@Override
	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElseThrow(() -> new InvalidIdException("InVaild id " + id));
	}

	@Override
	public Book updateBookDetails(Integer id, Book entity) {
		if (!bookRepository.existsById(id)) {
			throw new InvalidIdException("InVaild id " + id + "/n Book not found");
		}
		entity.setId(id);
		return bookRepository.save(entity);

	}

	@Override
	public Book updatePartialData(Integer id, Map<String, Object> jsonData) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new InvalidIdException("Invalid id " + id + "\nBook not found"));

		for (String field : jsonData.keySet()) {
			Object value = jsonData.get(field);
			if (value == null) {
				throw new InvalidFieldException("Field '" + field + "' cannot be null");
			}
			switch (field) {
			case "name":
				book.setName((String) value);
				break;
			case "author":
				book.setAuthor((String) value);
				break;
			case "releaseDate":
				try {
					LocalDate releaseDate = LocalDate.parse((String) value);
					book.setReleaseDate(releaseDate);
				} catch (DateTimeParseException e) {
					throw new InvalidDataFormatException(
							"Invalid date format for releaseDate. Expected format: yyyy-MM-dd");
				}
				break;
			default:
				throw new InvalidFieldException("Unrecognized field: " + field);
			}
		}

		return bookRepository.save(book);
	}

	

	@Override
	public void deleteBookById(Integer id) {
	    Book book = bookRepository.findById(id)
	            .orElseThrow(() -> new InvalidIdException("Invalid ID: " + id + ". Book not found"));
	    bookRepository.delete(book);
	}

}
