package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiExipction;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Rebositry.UserRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private  final UserRepositry userRepositry;
    public void add(User user){
        userRepositry.save(user);
    }

    public List get(){
        return userRepositry.findAll();
    }

    public void update(int id , User user){
        User user1=userRepositry.findUserById(id);
        if(user1==null){
            throw new ApiExipction("id not found");
        }
 user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRegistration_date(user.getRegistration_date());
        userRepositry.save(user1);
    }


    public void delete(int id){
        User user= userRepositry.findUserById(id);
        if(user==null){
            throw new ApiExipction("id not found");
        }
        userRepositry.delete(user);
    }


    }
