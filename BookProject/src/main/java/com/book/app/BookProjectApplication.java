package com.book.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.book.rest.BookController;
@ComponentScan
@ComponentScan(basePackageClasses = BookController.class)
@EnableJpaRepositories("com.book.persistence.repo")
@EntityScan({"com.book.persistence.domain","com.book.persistence.domain.BookRepo"})
@SpringBootApplication
public class BookProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookProjectApplication.class, args);
	}

}
