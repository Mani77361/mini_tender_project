/*
 * package com.tender.practice.mini_tenderproject.controller;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.tender.practice.mini_tenderproject.dto.LoginRequest; import
 * com.tender.practice.mini_tenderproject.dto.UserRequest; import
 * com.tender.practice.mini_tenderproject.dto.UserResponse; import
 * com.tender.practice.mini_tenderproject.serviceimpl.UserServiceImpl;
 * 
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/api") public class UserController {
 * 
 * private final UserServiceImpl userServiceImpl;
 * 
 * public UserController(UserServiceImpl userServiceImpl) {
 * 
 * this .userServiceImpl =userServiceImpl; }
 * 
 * //password-12345
 * 
 * @PostMapping public ResponseEntity<UserResponse> createUser(@RequestBody
 * UserRequest request){
 * 
 * UserResponse response = userServiceImpl.createUser(request);
 * 
 * return new ResponseEntity<>(response, HttpStatus.CREATED); }
 * 
 * 
 * @GetMapping("/getuser/{id}") public ResponseEntity<UserResponse>
 * getUserById(@PathVariable Long id){
 * 
 * UserResponse user = userServiceImpl.findUserById(id);
 * 
 * return ResponseEntity.ok(user);
 * 
 * 
 * }
 * 
 * @PostMapping("/login") public ResponseEntity<UserResponse> login(@RequestBody
 * LoginRequest request){
 * 
 * UserResponse response = userServiceImpl.login(request);
 * 
 * return ResponseEntity.ok(response);
 * 
 * }
 * 
 * }
 */