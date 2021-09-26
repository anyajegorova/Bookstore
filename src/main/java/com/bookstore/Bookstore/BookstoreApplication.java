package com.bookstore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.Bookstore.domain.Book;
import com.bookstore.Bookstore.domain.BookRepository;
import com.bookstore.Bookstore.domain.Category;
import com.bookstore.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Category category1 = new Category("Novel");
			Category category2 = new Category("Fantasy Fiction");
			
			Book book1 = new Book("The Catcher in the Rye", "J.D.Salinger", 1951, "111-111-111", 25.90, crepository.findByName("Novel").get(0));
			Book book2 = new Book("Lolita", "V.Nabokov", 1955, "222-222-222", 15.30, crepository.findByName("Novel").get(0));
			Book book3 = new Book("The Name of the Wind", "Patrick Rothfuss", 2007, "333-333-333", 26.40, crepository.findByName("Fantasy Fiction ").get(0));



			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			
			crepository.save(category1);
			crepository.save(category2);

		};
	}

}
