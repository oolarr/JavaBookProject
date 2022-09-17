package com.book.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.persistence.domain.Book;
import com.book.persistence.domain.BookDTO;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

	BookDTO save(BookDTO book);
	
	

}
