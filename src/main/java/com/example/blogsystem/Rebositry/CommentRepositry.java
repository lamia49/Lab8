package com.example.blogsystem.Rebositry;

import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepositry extends JpaRepository<Comment,Integer> {
    Comment findCommentById(int id);

    @Query("select comment from Comment comment where comment.postId=?1")
    List<Comment> byPostId(Integer postId);

    @Query("select comment from Comment comment where comment.userId=?1")
    List<Comment> byUserId (Integer postId);


    List<Comment>findCommentByCommentDate(LocalDate date);

}
