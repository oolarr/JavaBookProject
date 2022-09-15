package com.book.rest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.app.services.BookService;
import com.book.persistence.domain.Author;
import com.book.persistence.domain.Book;
import com.book.persistence.domain.BookDTO;

@RestController
public class BookController {
	
	private BookService service;
	
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/test")
	public String test() {
		return "Hello World! Books!!";
	}
	
	@PostMapping(value = "/create",  consumes= {"application/json"})
	public BookDTO addBook(@RequestBody Book book) {
		return this.service.addBook(book);
	}
	
	@GetMapping("/getAll")
	public List<BookDTO> getAll() {
		return this.service.getAll();		
	}
	
	@GetMapping("/getAuthors/{id}")
	public Set<Author> getAuthors(@PathVariable Long id, @RequestBody Book book){
		return this.service.getAuthors(id, book);
	}
	
	@GetMapping("/findBook/{id}")
	public Optional<Book> findBook(@PathVariable Long id) {
		return this.service.findBook(id);
	}
	
	@GetMapping("/find/{name}")
	public List<Author> findAuthorByNameContaining(@PathVariable String name){
		return this.service.findAuthorByNameContaining(name);
	}
	@PutMapping("/update")
	public BookDTO updateBook(@PathParam("id") Long id, @RequestBody Book book) {
		return this.service.updateBook(id, book);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean removeBook(@PathVariable Long id) {
		return this.service.removeBook(id);
	}

}
