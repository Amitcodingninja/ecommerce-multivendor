package com.amitXplode.service;

import com.amitXplode.domain.USER_ROLE;
import com.amitXplode.response.LoginRequest;
import com.amitXplode.response.AuthResponse;
import com.amitXplode.response.SignupRequest;

public interface AuthService {
    void sentLoginOtp(String email , USER_ROLE role) throws Exception;
    String createUser(SignupRequest req) throws Exception;
    AuthResponse signin(LoginRequest req);

}
