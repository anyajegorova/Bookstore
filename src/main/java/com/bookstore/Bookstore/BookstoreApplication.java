package com.bookstore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.Bookstore.domain.Book;
import com.bookstore.Bookstore.domain.BookRepository;
import com.bookstore.Bookstore.domain.Category;
import com.bookstore.Bookstore.domain.CategoryRepository;
import com.bookstore.Bookstore.domain.User;
import com.bookstore.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			//Creating categories
			
			Category category1 = new Category("Novel");
			Category category2 = new Category("Fantasy Fiction");
			
			crepository.save(category1);
			crepository.save(category2);
			
			//Adding books
			
			Book book1 = new Book("The Catcher in the Rye", "J.D.Salinger", 1951, "111-111-111", 25.90, crepository.findByName("Novel").get(0));
			Book book2 = new Book("Lolita", "V.Nabokov", 1955, "222-222-222", 15.30, crepository.findByName("Novel").get(0));
			

			
			repository.save(book1);
			repository.save(book2);
					
			
			//Creating users
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
		

		};
	}

}
