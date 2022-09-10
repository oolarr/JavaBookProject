package com.book.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@GetMapping("/test")
	public String test() {
		return "Hello World! Books!!";
	}

}
