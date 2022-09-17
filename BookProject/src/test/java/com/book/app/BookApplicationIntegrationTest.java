package com.book.app;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.book.app.services.BookService;
import com.book.persistence.domain.Book;
import com.book.persistence.domain.BookDTO;
import com.book.persistence.repo.BookRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class BookApplicationIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	
	@Autowired
	BookRepo repo;
	
	@MockBean
	private Book book;
	
	@Autowired
	private Book testBook;
	private Book testBookId;
	private BookDTO updatedTestBook;
	private List<BookDTO> booksInDb = new ArrayList<>();
	private BookDTO bookSaved;
	
	@MockBean
	private BookService service;
	
	@BeforeEach
	public void init() {
		List<Book> books = List.of(new Book("Love", "123XYZ", 1996),
				new Book("Love Again", "456GKR", 1999));
		
//		booksInDb = List.of(new BookDTO(1L,"Love", "123XYZ", 1996, null),
//				new BookDTO(2L, "Love Again", "456GKR", 1999, null));
		
		testBook = new Book("Alice in WonderLand", "123GYT", 1864);
		bookSaved = new BookDTO(3L, "Alice in WonderLand", "123GYT", 1864, null);
		updatedTestBook = new BookDTO(1L, "The Jungle Book", "456GKR", 1894, null);
		
		
	}
	
	@Test
	void testAddBook() throws Exception{
		
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/create");
		// specifying accept header return type
//		mockRequest.contentType(MediaType.APPLICATION_JSON);
//		mockRequest.content(mapper.writeValueAsString(testBook));
//
//		mockRequest.accept(MediaType.APPLICATION_JSON);
//		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
//				.json(mapper.writeValueAsString(bookSaved));
//
//		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

		
		String testBookAsJSON = this.mapper.writeValueAsString(testBook);
		String savedBookAsJSON = this.mapper.writeValueAsString(bookSaved);
		
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(testBookAsJSON);
		
		ResultMatcher checkStatus = status().isOk();
//		ResultMatcher checkContent = content().json(savedBookAsJSON);
	
		this.mockMvc.perform(request).andExpect(checkStatus);
	}
	
	@Test
	public void testGetAllBooks() throws Exception {
		// mock http request builder
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/getAll");
		// specifying accept header return type
		mockRequest.accept(MediaType.APPLICATION_JSON);
		// JSON string for obj mapper
		String books = mapper.writeValueAsString(booksInDb);
		// result matcher
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(books);
		// request and assert
		mockMvc.perform(mockRequest).andExpect(statusMatcher);
	}
	

//	@Test
//	public void testUpdateBook() throws Exception {
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
//				"/update?id=1");
//		// specifying accept header return type
//		mockRequest.contentType(MediaType.APPLICATION_JSON);
//		mockRequest.content(mapper.writeValueAsString(updatedTestBook));
//		mockRequest.accept(MediaType.APPLICATION_JSON);
//		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
//				.json(mapper.writeValueAsString(updatedTestBook));
//
//		mockMvc.perform(mockRequest).andExpect(contentMatcher);
//	}
	
	@Test
	public void testDeleteById() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/delete/1");
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		mockMvc.perform(mockRequest).andExpect(statusMatcher);
	}




}
