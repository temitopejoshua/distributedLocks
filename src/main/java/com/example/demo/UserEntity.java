package com.example.demo;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", indexes = @Index( name = "fn_index",columnList = "firstName"))
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String password;

    private String firstName;

}
