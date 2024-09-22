package com.UserManagement.user.Controller;

import com.UserManagement.user.Model.user;
import com.UserManagement.user.Repository.userRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.awt.print.Book;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/home")

public class userController {

    @Autowired
    private userRepository userRepo;

    @PostMapping("/add")
    public ResponseEntity<user> createUser(@RequestBody user user1)
    {
        user user2 = userRepo.save(user1);
        return ResponseEntity.ok().body(user2);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<user>> fetchUser()
    {
        List<user> userData = userRepo.findAll();
        return ResponseEntity.ok().body(userData);
    }

    @GetMapping("/fetchall")
    public ResponseEntity<List<user>>fetchAllUser()
    {
        List<user> userData = userRepo.findAll();
        return ResponseEntity.ok().body(userData);

    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Optional<user>>getById(@PathVariable Long id)
    {
        Optional<user> userInfo = userRepo.findById(id);
        if (userInfo.isPresent())
        {
            return ResponseEntity.ok().body(userInfo);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/deleteall")
    public ResponseEntity<String> deleteall()
    {
        userRepo.deleteAll();
        return ResponseEntity.ok().body("Deleted All Records...");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id)
    {
        userRepo.deleteById(id);
        return ResponseEntity.ok().body("Deleted :" + (id));
    }


}
