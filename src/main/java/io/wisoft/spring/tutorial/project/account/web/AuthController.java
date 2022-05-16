package io.wisoft.spring.tutorial.project.account.web;

import io.wisoft.spring.tutorial.project.global.web.validator.image.ValidationSequence;
import io.wisoft.spring.tutorial.project.account.application.AuthService;
import io.wisoft.spring.tutorial.project.account.web.dto.req.LoginRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.req.SignUpRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignInResponse;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(
            @ModelAttribute
            @Validated(ValidationSequence.class) final SignUpRequest request
    ) {
        final SignUpResponse response = this.authService.signup(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<SignInResponse> login(@RequestBody @Valid final LoginRequest request) {
        final SignInResponse response = this.authService.login(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
