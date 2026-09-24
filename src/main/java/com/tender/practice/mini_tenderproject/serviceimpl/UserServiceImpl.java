/*
 * package com.tender.practice.mini_tenderproject.serviceimpl;
 * 
 * import org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.tender.practice.mini_tenderproject.dto.LoginRequest; import
 * com.tender.practice.mini_tenderproject.dto.UserRequest; import
 * com.tender.practice.mini_tenderproject.dto.UserResponse; import
 * com.tender.practice.mini_tenderproject.entity.User; import
 * com.tender.practice.mini_tenderproject.repository.UserRepository; import
 * com.tender.practice.mini_tenderproject.service.UserService;
 * 
 * @Service public class UserServiceImpl implements UserService {
 * 
 * private final UserRepository userRepository; private final PasswordEncoder
 * passwordEncoder;
 * 
 * public UserServiceImpl(UserRepository userRepository,PasswordEncoder
 * passwordEncoder) { this.userRepository = userRepository; this.passwordEncoder
 * = passwordEncoder; }
 * 
 * @Override public UserResponse createUser(UserRequest request) {
 * 
 * User user = new User();
 * 
 * user.setUserName(request.getUserName());
 * user.setPassword(request.getPassword()); user.setEmail(request.getEmail());
 * user.setRole(request.getRole());
 * 
 * User savedUser = userRepository.save(user);
 * 
 * return UserResponse.builder() .userName(user.getUserName())
 * .password(user.getPassword()) .email(user.getEmail()) .build(); }
 * 
 * @Override public UserResponse findUserById(Long id) { User user =
 * userRepository.getById(id);
 * 
 * 
 * return UserResponse.builder() .userName(user.getUserName())
 * .password(user.getPassword()) .email(user.getEmail()) .build();
 * 
 * 
 * }
 * 
 * @Override public UserResponse login(LoginRequest request) {
 * 
 * User user = userRepository.findByUserName(request.getUserName()).orElseThrow(
 * ()-> new RuntimeException("User Name Not Found :" + request));
 * 
 * if(!user.getPassword().equals(request.getPassword())) {
 * 
 * throw new RuntimeException("Password Invalid");
 * 
 * } return UserResponse.builder() .userName(user.getUserName())
 * .email(user.getEmail()) .role(user.getRole()) .build(); }
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 */