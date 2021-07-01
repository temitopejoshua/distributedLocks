package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;

@SpringBootApplication
@Slf4j
public class DistributedlockApplication {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DistributedlockApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner run(){
		return (args) -> {
			userRepository.save(UserEntity.builder().username("test123")
					.firstName("First Name")
					.password("test")
					.build());

		};
	}


}
