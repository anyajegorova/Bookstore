package com.bookstore.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bookstore.Bookstore.domain.Category;
import com.bookstore.Bookstore.domain.CategoryRepository;
import static org.assertj.core.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameReturnsCategory() {
		List<Category> categories = repository.findByName("Fantasy");
		assertThat(categories.get(1).getCategoryId()).isEqualTo(2);
		
	}
	

}
