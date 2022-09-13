package com.book.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.book.persistence.domain.Book;
import com.book.persistence.domain.BookDTO;
import com.book.persistence.repo.BookRepo;
@Component
@Service
public class BookService {
	@Autowired
	private BookRepo repo;
	@Autowired
	private ModelMapper mapper;
	
	public BookService(BookRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private BookDTO mapToDTO(Book book) {
		return this.mapper.map(book, BookDTO.class);
	}
	
	public BookDTO addBook(Book book) {
		Book saved = this.repo.save(book);
		return this.mapToDTO(saved);
	}
	
	public List<BookDTO> getAll(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public BookDTO updateBook(Long id, Book newBook) {
		Optional<Book> existingOptional = this.repo.findById(id);
		Book existing = existingOptional.get();
		
		existing.setTitle(newBook.getTitle());
		existing.setAuthor(newBook.getAuthor());
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
