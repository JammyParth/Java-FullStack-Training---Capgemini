package com.capg.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksrepository;
	
	public void addBooks(Books books) {
		booksrepository.save(books);
	}
	
	
	//get all books form database through SpringDataJPA
	
	public List<Books> getAllBooks(){
		List<Books> books = new ArrayList<Books>();
		booksrepository.findAll().forEach(b1 -> books.add(b1));
		System.out.println(books);
		return books;
	}
	
	//retrive find by book
	public Books getBookById(int id) {
		return booksrepository.findById(id).get();
	}
	
	//update the record
	public void update(Books books) {
		booksrepository.save(books);
	}
}
