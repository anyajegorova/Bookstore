package com.bookstore.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bookstore.Bookstore.domain.Book;
import com.bookstore.Bookstore.domain.BookRepository;
import com.bookstore.Bookstore.domain.Category;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	// Testing find functionality
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Lolita");
		assertThat(books.get(1).getAuthor()).isEqualTo("V.Nabokov");
		
	}

	//Testing create functionality
	@Test
	public void createNewBook() {
		Book book = new Book("Nineteen Eighty-Four", "George Orwell", 1984, "555-555-555", 11.95 , new Category("Science fiction") );
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	//Testing delete functionality
	@Test
	public void deleteBook() {
		Book book = new Book("Nineteen Eighty-Four", "George Orwell", 1984, "555-555-555", 11.95 , new Category("Science fiction") );
		repository.save(book);
		repository.deleteById(book.getId());
		assertThat(book.getId()).isNull();
	}
}
