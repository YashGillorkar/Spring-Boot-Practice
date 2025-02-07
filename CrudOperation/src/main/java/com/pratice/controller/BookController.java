package com.pratice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.entity.Book;
import com.pratice.service.BookServiceI;




@RequestMapping("/book")
@RestController
public class BookController {
	
	@Autowired BookServiceI bookServiceI;
	
	@PostMapping("/post")
	public ResponseEntity<Book> addBookToLibrary(@RequestBody Book entity) {
		return new ResponseEntity<Book>(bookServiceI.postBook(entity), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getSingleBook(@PathVariable("id") Integer id) {
		return new ResponseEntity<Book>(bookServiceI.getBookById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book entity) {		
		return new ResponseEntity<Book>(bookServiceI.updateBookDetails(id,entity),HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Book> partialBookUpdate(@PathVariable("id") Integer id, @RequestBody Map<String, Object> jsonData){
		return new ResponseEntity<Book>(bookServiceI.updatePartialData(id,jsonData),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteSingleBook(@PathVariable("id") Integer id) {
		return new ResponseEntity<Book>( HttpStatus.OK);
	}

}
