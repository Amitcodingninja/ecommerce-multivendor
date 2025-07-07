package com.amitXplode.service.impl;

import com.amitXplode.config.JwtProvider;
import com.amitXplode.model.User;
import com.amitXplode.repository.UserRepository;
import com.amitXplode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);

//        User user = this.findUserByEmail(email);
//        if (user == null) {
//            throw new Exception("User not found with email - " + email);
//        }
        return this.findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("user not found with email - " + email);
        }
        return user;
    }
}
