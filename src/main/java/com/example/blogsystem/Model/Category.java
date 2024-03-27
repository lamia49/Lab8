package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    @NotEmpty(message = "must be not empty")
//    @Min(value = 4)
    @Column(columnDefinition = "varchar(10) unique")  //check(length(name)>4)
    private String name;


}
