package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@AllArgsConstructor
@Slf4j
public class Controller {
    private UserRepository userRepository;
    private EntityManager entityManager;

    @GetMapping("/")
   public ResponseEntity<Object> getAll(){

        return ResponseEntity.ok(userRepository.findAll());
   }

    @GetMapping("/t-father")
    public ResponseEntity<Object> tfather(){

        return ResponseEntity.ok("It Finally worked");
    }
//    @GetMapping("/{id}")
//    @SneakyThrows
//    public ResponseEntity<Object> findById(@PathVariable long id){
//        UserEntity userEntity = userRepository.findById(id).get();
//        return ResponseEntity.ok(userEntity);
//    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity findById(){
        concurrentTest();
        return ResponseEntity.ok().build();
    }
    private void concurrentTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(findId());
//        executorService.submit(findId());
        executorService.shutdown();
    }
    private Runnable findId(){

        return () -> System.out.println(userRepository.findById(1));
    }
}
