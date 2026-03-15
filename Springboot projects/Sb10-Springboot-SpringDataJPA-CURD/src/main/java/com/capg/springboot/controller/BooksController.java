package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//book search by ID
	@GetMapping("/bookid/{bookid}")
	public Books getBookById(@PathVariable("bookid") int bookid) {
		return bookService.getBookById(bookid);
	}
	
	//update PUT
	@PutMapping("/updatebook")
	public Books update(@RequestBody Books books) {
		bookService.update(books);
		return books;
	}
	
	
	//delete records
	@DeleteMapping("/bookid/{bookid}")
	public void deleteBook(@PathVariable("bookid") int bookid) {
		bookService.delete(bookid);
	}
	
	
	
	
	
	
	
}