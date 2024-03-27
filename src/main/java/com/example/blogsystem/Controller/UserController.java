package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid User user , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        userService.add(user);

        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(userService.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid User user,Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        userService.update(id,user);
        return ResponseEntity.status(20).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        userService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }
}
