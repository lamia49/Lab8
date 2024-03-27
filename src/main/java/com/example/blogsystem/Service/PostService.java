package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiExipction;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Rebositry.CatogaryRepositry;
import com.example.blogsystem.Rebositry.PostRepositry;
import com.example.blogsystem.Rebositry.UserRepositry;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {
    private  final PostRepositry postRepositry;
    private final CatogaryRepositry catogaryRepositry;
    private final UserRepositry userRepositry;
    public void add(Post post){
        User user= userRepositry.findUserById(post.getUserId());
        Category category= catogaryRepositry.findCategoryById(post.getCategoryId());
        if(user==null){
            throw new ApiExipction("user id not found");
        }else if(category==null){
            throw new ApiExipction("catogary id not found");
        }
        postRepositry.save(post);
    }

    public List get(){
        return postRepositry.findAll();
    }

    public void update(int id , Post post){
        Post post1=postRepositry.findPostById(id);
        if(post1==null){
            throw new ApiExipction("id not found");
        }
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setPublishDate(post.getPublishDate());
        postRepositry.save(post1);
    }


    public void delete(int id){
        Post post= postRepositry.findPostById(id);
        if(post==null){
            throw new ApiExipction("id not found");
        }
        postRepositry.delete(post);
    }

    public List<Post> getByUserId(int id){
        List<Post> posts=postRepositry.byUser_id(id);
        if(posts.isEmpty()){
            throw new ApiExipction("user does not have any post!");
        }
        return posts;
    }

    public List<Post> getByTitle(String title){
        List<Post> posts=postRepositry.byTitl(title);
        if(posts.isEmpty()){
            throw new ApiExipction("not subject have this title!");
        }
        return posts;
    }

   public List<Post>getByDate(LocalDate date){
        List<Post>posts=postRepositry.findPostByPublishDate(date);
        if(posts.isEmpty()){
            throw new ApiExipction("No posts published in this date!");
        }
        return posts;
   }

    public List<Post>getByBeforDate(LocalDate date){
        List<Post>posts=postRepositry.findPostByPublishDateBefore(date);
        if(posts.isEmpty()){
            throw new ApiExipction("No posts published before this date!");
        }
        return posts;
    }



}
