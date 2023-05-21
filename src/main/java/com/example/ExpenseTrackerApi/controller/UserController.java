package com.example.ExpenseTrackerApi.controller;

import com.example.ExpenseTrackerApi.dto.SignInInput;
import com.example.ExpenseTrackerApi.dto.SignInOutput;
import com.example.ExpenseTrackerApi.dto.SignUpInput;
import com.example.ExpenseTrackerApi.dto.SignUpOutput;
import com.example.ExpenseTrackerApi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //Regestering or Signing Up User

    @PostMapping(value = "/signup")
    public SignUpOutput signup(@Valid @RequestBody SignUpInput signUpInput){
        return userService.signup(signUpInput);
    }

    //User Sign In

    @PutMapping(value = "/signin")
    public SignInOutput signin(@RequestBody SignInInput signInInput){
        return userService.signin(signInInput);
    }

}
