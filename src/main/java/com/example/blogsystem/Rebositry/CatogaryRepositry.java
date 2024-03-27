package com.example.blogsystem.Rebositry;

import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatogaryRepositry extends JpaRepository<Category,Integer> {
    Category findCategoryById(int id);
    @Query("select catogary from Category catogary where catogary.name=?1")
    List<Category> byName(String name);
}
