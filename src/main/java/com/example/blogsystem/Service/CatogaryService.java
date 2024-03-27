package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiExipction;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Rebositry.CatogaryRepositry;
import com.example.blogsystem.Rebositry.UserRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatogaryService {
    private  final CatogaryRepositry catogaryRepositry;
    public void add( Category category){
        catogaryRepositry.save(category);
    }

    public List get(){
        return catogaryRepositry.findAll();
    }

    public void update(int id , Category category){
        Category category1=catogaryRepositry.findCategoryById(id);
        if(category1==null){
            throw new ApiExipction("id not found");
        }
        category1.setName(category.getName());
    }


    public void delete(int id){
        Category category=catogaryRepositry.findCategoryById(id);
        if(category==null){
            throw new ApiExipction("id not found");
        }
        catogaryRepositry.delete(category);
    }


    public List<Category> byName(String name){
        List<Category> categoris=catogaryRepositry.byName(name);
        if (categoris.isEmpty()){
            throw new ApiExipction("No catgaries with this name");
        }
        return categoris;

    }


}
