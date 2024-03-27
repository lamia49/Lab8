package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CatogaryService;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/blog/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Comment comment, Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        commentService.add(comment);

        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(commentService.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid Comment comment,Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        commentService.update(id,comment);
        return ResponseEntity.status(20).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        commentService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }



    @GetMapping("/by_postId/{idpost}")
    public ResponseEntity byPostId(@PathVariable int idpost){
        return ResponseEntity.status(200).body(commentService.byPostId(idpost));
    }


    @GetMapping("/by_user/{userId}")
    public ResponseEntity byUserId(@PathVariable int userId){
        return ResponseEntity.status(200).body(commentService.byUserId(userId));
    }

    @GetMapping("/by_Date/{date}")
    public ResponseEntity getByPublished(@PathVariable LocalDate date){

        return ResponseEntity.status(200).body(commentService.byDate(date));
    }
}
