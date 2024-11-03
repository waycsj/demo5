package com.example.demo5.service;

import com.example.demo5.domain.User;
import com.example.demo5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(int id) {
    return userRepository.findById(id).get();
  }

  public User updateUser(int id, User user) {
    User oldUser = userRepository.findById(id).get();
    oldUser.setName(user.getName());
    oldUser.setEmail(user.getEmail());
    oldUser.setAge(user.getAge());
    oldUser.setAddress(user.getAddress());
    userRepository.save(oldUser);
    return oldUser;
  }

  public void deleteUserById(int id, User user) {
    userRepository.deleteById(id);
  }
}
