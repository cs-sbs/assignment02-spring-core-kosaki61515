package edu.sbs.cs.controller;


import edu.sbs.cs.entity.User;
import edu.sbs.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam("id") int id) {
        Optional<User> userOptional = userService.findUserById(Long.valueOf(id));
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<User>> getUsersByFilter(@RequestParam("start") String start,
                                                       @RequestParam("end") String end) {
        return ResponseEntity.ok(userService.findUserBySE(start, end));

    }




//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        return ResponseEntity.ok(userService.updateUser(id, user));
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<User>> searchUser(@RequestParam String start) {
//        return ResponseEntity.ok(userService.searchUser(start));
//    }
}
