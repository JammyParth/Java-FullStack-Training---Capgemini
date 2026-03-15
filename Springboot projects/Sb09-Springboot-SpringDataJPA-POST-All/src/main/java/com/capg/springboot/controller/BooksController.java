package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BooksController {
	@Autowired
	BooksService bookService;
	
	//Add books
	@PostMapping("/addbook")
	public int addBook(@RequestBody Books books) {
		bookService.addBooks(books);
		return books.getBookid();
	}
	
	//Retrieve all books
	@GetMapping("allbooks")
	public List<Books>getAllBooks(){
		return bookService.getAllBooks();
	}
	
}