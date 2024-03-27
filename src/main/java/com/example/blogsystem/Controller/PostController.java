package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/blog/post")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Post post , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        postService.add(post);

        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(postService.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid Post post, Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        postService.update(id,post);
        return ResponseEntity.status(20).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        postService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }


    @GetMapping("/by_userid/{id}")
    public ResponseEntity getByUserId(@PathVariable int id){

        return ResponseEntity.status(200).body(postService.getByUserId(id));
    }
    @GetMapping("/by_title/{titl}")
    public ResponseEntity getByUserId(@PathVariable String titl){

        return ResponseEntity.status(200).body(postService.getByTitle(titl));
    }

    @GetMapping("/by_publishDate/{date}")
    public ResponseEntity getByPublished(@PathVariable LocalDate date){

        return ResponseEntity.status(200).body(postService.getByDate(date));
    }

    @GetMapping("/by_BeforDate/{date}")
    public ResponseEntity getByBeforDate(@PathVariable LocalDate date){

        return ResponseEntity.status(200).body(postService.getByBeforDate(date));
    }







}
