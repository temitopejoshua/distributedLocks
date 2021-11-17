package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;


@SpringBootTest
class DistributedlockApplicationTests {
//	@Autowired
	@Mock
	private  UserRepository repository;
//	@Test
	void contextLoads() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(test());
		executorService.submit(test());
		executorService.shutdown();
	}
	public Runnable test(){

		return () -> System.out.println(System.currentTimeMillis());
	}

	@BeforeEach
	 void setup(){
		UserEntity en =UserEntity.builder().id(1).username("Adewale").build();
//		when(repository.save(en)).thenReturn(en);

		when(repository.save(any(UserEntity.class))).thenReturn(en);



	}
	@Test
	void findByIdTest(){
		System.out.println(repository.findById(1L));
//		mockRepository.
//		Optional<UserEntity> result = Optional.empty();
//		Mockito.when(repository.findById(1L)).thenReturn(result);
//		assertNotNull(result);
	}

}
