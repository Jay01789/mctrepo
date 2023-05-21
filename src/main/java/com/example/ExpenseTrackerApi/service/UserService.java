package com.example.ExpenseTrackerApi.service;

import com.example.ExpenseTrackerApi.dto.SignInInput;
import com.example.ExpenseTrackerApi.dto.SignInOutput;
import com.example.ExpenseTrackerApi.dto.SignUpInput;
import com.example.ExpenseTrackerApi.dto.SignUpOutput;
import com.example.ExpenseTrackerApi.model.AuthenticationToken;
import com.example.ExpenseTrackerApi.model.User;
import com.example.ExpenseTrackerApi.repo.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private iUserRepo userRepo;

    @Autowired
    private  AuthenticationTokenService authenticationTokenService ;

    public SignUpOutput signup(SignUpInput signUpInput) {

        //checking if user already exist

        User user = userRepo.findFirstByUserEmail(signUpInput.getUserEmail());

        if(user != null){
            throw  new IllegalStateException("User ALready Exist,SignIn Please");
        }

        //saving user

        user = new User(signUpInput.getUserName(),signUpInput.getUserEmail(),signUpInput.getUserPassword());
        userRepo.save(user);

        //creating Auth Token for user

        AuthenticationToken token = new AuthenticationToken(user);
        authenticationTokenService.save(token);


        return new SignUpOutput("Sign Up Scussesfull","Please SignIn Now");


    }

    public SignInOutput signin(SignInInput signInInput) {

        User user = userRepo.findFirstByUserEmail(signInInput.getUser_Email());
        if(user == null){
            throw  new IllegalStateException("Please Sign Up First");
        }

            //check password

        boolean isPasswordVaild = signInInput.getUser_Password().equals(user.getUser_password());

        if(!isPasswordVaild){
            throw new IllegalStateException("/Please check the Email/Password");
        }


        AuthenticationToken token =authenticationTokenService.getToken(user);
        return new SignInOutput("Sign In Scussesfull",token.getToken() );

    }
}
