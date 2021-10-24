package com.bookstore.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bookstore.Bookstore.domain.User;
import com.bookstore.Bookstore.domain.UserRepository;
import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest

public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User users = repository.findByUsername("user");
		assertThat(users.getPasswordHash()).isNotNull();		
		
	}
	
}
