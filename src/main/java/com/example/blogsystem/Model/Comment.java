package com.example.blogsystem.Model;

import jakarta.persistence.*;
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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    @NotNull(message = " user id must be not empty")
    @Column(columnDefinition = "int ")
    private Integer  userId;
    @NotNull(message = "id post must be not null")
    @Column(columnDefinition = "int")
    private Integer postId;
    @NotEmpty(message = " content must be not empty")
    @Column(columnDefinition = "varchar(250) not null")
    private String  content;
    @DateTimeFormat
    @Column(columnDefinition = "DATE")
    private LocalDate commentDate;
}
