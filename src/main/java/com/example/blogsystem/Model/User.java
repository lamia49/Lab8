package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "username must be not null")
    @Column(columnDefinition = "varchar(20) not null UNIQUE")
    private String username;
    @NotEmpty(message = "password must be not empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String  password;
    @Email(message ="must be valid email ")
    @Column(columnDefinition =" varchar(50) UNIQUE not null")
    private String email;
    @DateTimeFormat
    @Column(columnDefinition = "DATE")
    private LocalDate registration_date;
}
