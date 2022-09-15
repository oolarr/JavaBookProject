package com.book.persistence.domain;

import java.util.Set;

public class BookDTO {
	private Long id;
	private String title;
	private String isbn;	
	private int year;
	private Set<Author> authors;
	
	
	public BookDTO() {
		super();
	}

	public BookDTO(Long id, String title, String isbn, int year, Set<Author> authors) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	

	
	
	


}
