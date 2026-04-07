package com.javweb.mantenjavweb.controller;
/**
 * Copyright(C) [2026] [Luvina Software Company]
 * <p>
 * [UserController.java], [Apr 6,2026] [ntlong]
 */

import com.javweb.mantenjavweb.entity.User;
import com.javweb.mantenjavweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Tao UserController de dinh nghia rest API giao tiep voi FE
 * author : [ntlong]
 */
@RestController //Dinh nghia kieu Controller la Rest Controller
@RequestMapping("/api/users") //link API cho toan bo Controller
@CrossOrigin(origins = "http://localhost:3000") //Cho phep localhost o port 3000 goi den API
public class UserController {
 @Autowired
 private UserRepository userRepository; //goi Repository de giao tiep voi db

 /**
  * goi tat ca User bang repository
  * author: [ntlong]
  * @return List<User>: danh sach tat ca User
  * */
 /*@GetMapping
 public List<User> getAllUsers() {
  return userRepository.findAll();
 }*/

 /**
  * goi user co id la {id} bang repository
  * author: [ntlong]
  * @return Optional<User>: User co id la {id}
  * */
 @GetMapping("/{id}")
 public Optional<User> getUserById(@PathVariable Long id) {
  return userRepository.findById(id);
 }

 /**
  * goi User theo phan trang
  * author: [ntlong]
  * @RequestParam(defaultValue = "0") int page: trang hien tai (default la 0)
  * @RequestParam(defaultValue = "20") int size: so luong ban ghi tren 1 trang (default la 20)
  * @return Page<User>: danh sach User trong 1 trang
  * */
 @GetMapping
 public Page<User> getAllUsers(
         @RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "20") int size
 ) {
  return userRepository.findAll(PageRequest.of(page, size));
 }
 /**
  * tao User moi
  * author: [ntlong]
  * @RequestBody User user: User can tao moi
  * @return User: User da tao moi
  * */
 @PostMapping
 public User createUser(@RequestBody User user) {
  return userRepository.save(user);
 }
 /**
  * xoa User co id la {id}
  * author: [ntlong]
  * @PathVariable Long id: id cua User
  * */
 @DeleteMapping("/{id}")
 public void deleteUserById(@PathVariable Long id) {
  userRepository.deleteById(id);
 }

 /**
  * cap nhat User co id la {id}
  * author: [ntlong]
  * @PathVariable Long id: id cua User
  * @RequestBody User user: User can cap nhat
  * @return User: User da cap nhat
  * */
 @PutMapping("/{id}")
 public User updateUserById(@PathVariable Long id, @RequestBody User user) {
  user.setId(id);
  return userRepository.save(user);
 }
}
