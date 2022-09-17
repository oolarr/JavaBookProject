package com.book.app;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.book.app.services.BookService;
import com.book.persistence.domain.Book;
import com.book.persistence.domain.BookDTO;
import com.book.persistence.repo.BookRepo;

@SpringBootTest
public class BookServiceUnitTest {
	@Autowired
	private BookService service;
	
	@MockBean
	private BookRepo repo;
	
	private Book newDTO;
	
	
	
	
	@Test
	void testAddBook() {
		BookDTO newBook = new BookDTO(null, "Love", "123XYZ", 1996, null);
		BookDTO bookCreated = new BookDTO(1L, "Love", "123XYZ", 1996, null);
		
		Mockito.when(this.repo.save(newBook)).thenReturn(bookCreated);
		
		Assertions.assertThat(this.repo.save(newBook)).isEqualTo(bookCreated);
	}
	
	@Test
	void testGetAllBooks() {
		final List<BookDTO> books = List.of(new BookDTO(null, "Love", "123XYZ", 1996, null),
				new BookDTO(null, "Love Again", "456GKR", 1999, null));
		
		Mockito.when(this.service.getAll()).thenReturn(books);
		Assertions.assertThat(books.size()).isGreaterThan(0);
	}
	
	@Test
	void testFindBookById() {
		final Long id = 1L;
		final Optional<Book> newBook = Optional.ofNullable(new Book("A Happy Place", "456ABC", 2006));
		
		Mockito.when(this.repo.findById(id)).thenReturn(newBook);
		Assertions.assertThat(this.service.findBook(id)).isEqualTo(newBook);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
//	@Test
//	void testGetBookAuthors() {
//		Book newBook = new Book("A Happy Place", "456ABC", 2006);
//		
//		Mockito.when(this.service.getAuthors(, newBook)).thenReturn(newBook.getAuthors());
//		Assertions.assertThat(this.service.getAuthors(1L, newBook)).hasSize(0);
//	}
	
	@Test
	void testRemoveBook() {
		final long id = 1L;
		
		
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		Assertions.assertThat(this.service.removeBook(id)).isEqualTo(true);
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		
	}

	
	

}
