package com.book.app.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.app.exceptions.ResourceNotFoundException;
import com.book.persistence.domain.Author;
import com.book.persistence.domain.Book;
import com.book.persistence.domain.BookDTO;
import com.book.persistence.repo.AuthorRepo;
import com.book.persistence.repo.BookRepo;
@Component
@Service
public class BookService {
	@Autowired
	private BookRepo repo;
	
	@Autowired
	private AuthorRepo repo2;
	
	@Autowired
	private ModelMapper mapper;
	
	public BookService(BookRepo repo, AuthorRepo repo2, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.mapper = mapper;
	}
	
	private BookDTO mapToDTO(Book book) {
		return this.mapper.map(book, BookDTO.class);
	}
	
	public BookDTO addBook(Book book) {
		Book saved = this.repo.save(book);
		return this.mapToDTO(saved);
	}
	
	public Set<Author> getAuthors(Long id, Book book) {
		Optional<Book> existingOptional = this.repo.findById(id);
		Book existing = existingOptional.get();
		return existing.getAuthors();
	}
	
	public Optional<Book> findBook(Long id) {
		return Optional.of(repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Book with id " +id)));
	}
	
	public List<Author> findAuthorByNameContaining(@PathVariable String name){
		return repo2.findByNameContaining(name);
	}
	
	public List<BookDTO> getAll(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public BookDTO updateBook(Long id, Book newBook) {
		Optional<Book> existingOptional = Optional.of(this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Book with id " +id)));
		Book existing = existingOptional.get();
		
		existing.setTitle(newBook.getTitle());
		existing.setAuthors(newBook.getAuthors());
		existing.setIsbn(newBook.getIsbn());
		existing.setYear(newBook.getYear());
		
		Book updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean removeBook(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
