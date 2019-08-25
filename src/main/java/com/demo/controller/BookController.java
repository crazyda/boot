package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.AuthorSettings;

@RestController
public class BookController {

	@Value("${book.author}")
	private String bookAuthor;
	
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private AuthorSettings authorSettings;
	
	@RequestMapping("/book")
	String index() {
		
		return "book name is"+bookName +" and book author is:"+bookAuthor;
	}
	@RequestMapping("/book2")
	String index2() {
		
		return "book name is"+authorSettings.getName() +" and book author is:"+authorSettings.getAge();
	}
}
