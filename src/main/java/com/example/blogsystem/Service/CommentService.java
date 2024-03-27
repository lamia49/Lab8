package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiExipction;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Rebositry.CommentRepositry;
import com.example.blogsystem.Rebositry.PostRepositry;
import com.example.blogsystem.Rebositry.UserRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private  final CommentRepositry commentRepositry;
    private  final PostRepositry postRepositry;
    private  final UserRepositry userRepositry;
    public void add(Comment comment){
        User user=userRepositry.findUserById(comment.getUserId());
        Post post=postRepositry.findPostById(comment.getPostId());
        if(user==null){
            throw new ApiExipction("user id not found");
        }else if(post==null){
            throw  new ApiExipction("post id not found ");
        }
        commentRepositry.save(comment);
    }

    public List get(){
        return commentRepositry.findAll();
    }

    public void update(int id , Comment comment){
        Comment comment1=commentRepositry.findCommentById(id);
        if(comment1==null){
            throw new ApiExipction("id not found");
        }
        comment1.setContent(comment.getContent());
        comment1.setCommentDate(comment.getCommentDate());
    }


    public void delete(int id){
        Comment comment= commentRepositry.findCommentById(id);
        if(comment==null){
            throw new ApiExipction("id not found");
        }
        commentRepositry.delete(comment);
    }


    public List<Comment> byPostId(Integer postId){
        List<Comment> comments=commentRepositry.byPostId(postId);
        if(comments.isEmpty()){
            throw new ApiExipction("This post does not have comments");
        }
        return comments;
    }


    public List<Comment> byUserId(Integer UserId){
        List<Comment> comments=commentRepositry.byUserId(UserId);
        if(comments.isEmpty()){
            throw new ApiExipction("this user does not write any comment!");
        }
        return comments;
    }


    public List<Comment>byDate(LocalDate date){
        List<Comment> comments=commentRepositry.findCommentByCommentDate(date);
        if(comments.isEmpty()){
            throw new ApiExipction("no comment for this date!");
        }
        return comments;
    }




}
