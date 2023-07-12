package controller;

import model.User;
import repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    private ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<User>();
            usersRepository.getUsers().forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users/{id}")
    private ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = usersRepository.findById(id);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @PostMapping("/users")
    private ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            usersRepository.addUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/users/{id}")
    private ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        try {
            usersRepository.deleteUserById(id);
            return new ResponseEntity<>("User deleted succesfully", HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Cannot delete user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    private ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        try {
            user.setId(id);
                usersRepository.updateUser(user);
                return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
