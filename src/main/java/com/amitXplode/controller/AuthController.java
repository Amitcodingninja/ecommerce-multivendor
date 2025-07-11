package com.amitXplode.controller;

import com.amitXplode.domain.USER_ROLE;
import com.amitXplode.model.User;
import com.amitXplode.model.VerificationCode;
import com.amitXplode.repository.UserRepository;
import com.amitXplode.response.*;
import com.amitXplode.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest req) throws Exception {
        String jwt = authService.createUser(req);
        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setMessage("register Success");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);

        return ResponseEntity.ok(res);
    }

    @PostMapping("/sent/login-signup-otp")
    public ResponseEntity<ApiResponse> sendOtpHandler(@RequestBody LoginOtpRequest req) throws Exception {
        authService.sentLoginOtp(req.getEmail(), req.getRole());
        ApiResponse res = new ApiResponse();
        res.setMessage("otp sent successfully");
        return ResponseEntity.ok(res);
    }

    @PostMapping("/signing")
    public ResponseEntity<AuthResponse> loginHandler(@RequestBody LoginRequest req) throws Exception {
        AuthResponse authResponse = authService.signin(req);
        return ResponseEntity.ok(authResponse);
    }
}
