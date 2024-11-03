package com.example.demo5.controller;


import com.example.demo5.domain.User;
import com.example.demo5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller//MVC 패턴을 사용할 때 사용
@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/user")
  public User createUser(@RequestBody User user) {
return userService.createUser(user);
  }

  @GetMapping("/user")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/user/{userid}")
  public User getUserById(@PathVariable("userid") int userid) {
    return userService.getUserById(userid);
  }

  @PatchMapping("/user/{userid}")
  public User updateUser(@PathVariable("userid") int userid, @RequestBody User user) {
    return userService.updateUser(userid, user);
  }

  @DeleteMapping("/user/{userid}")
  public void deleteUser(@PathVariable("userid") int userid, @RequestBody User user) {
    userService.deleteUserById(userid, user);
  }
}