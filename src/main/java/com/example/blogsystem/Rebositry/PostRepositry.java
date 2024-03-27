package com.example.blogsystem.Rebositry;

import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepositry extends JpaRepository<Post,Integer> {
    Post findPostById(int id);
    @Query("select post from Post post where post.userId=?1")
    List<Post> byUser_id(Integer id);
    @Query("select post from Post post where post.title=?1")
    List<Post> byTitl(String titl);

    List<Post> findPostByPublishDate(LocalDate date);
    List<Post>findPostByPublishDateBefore(LocalDate date);


}
