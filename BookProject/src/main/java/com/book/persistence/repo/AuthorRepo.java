package com.book.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.persistence.domain.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{
	
	List<Author> findByNameContaining(String name);

}
