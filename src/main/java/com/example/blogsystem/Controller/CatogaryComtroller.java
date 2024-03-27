package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Service.CatogaryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog/catogary")
@AllArgsConstructor
public class CatogaryComtroller {
    private final CatogaryService catogaryService;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Category category, Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        catogaryService.add(category);

        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(catogaryService.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid Category category,Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        catogaryService.update(id,category);
        return ResponseEntity.status(20).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        catogaryService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }


    @GetMapping("/by_name/{name}")
    public ResponseEntity byName(@PathVariable String name){
       return ResponseEntity.status(200).body(catogaryService.byName(name));

    }
}
