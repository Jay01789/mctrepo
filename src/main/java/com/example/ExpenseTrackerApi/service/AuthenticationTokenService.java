package com.example.ExpenseTrackerApi.service;

import com.example.ExpenseTrackerApi.model.AuthenticationToken;
import com.example.ExpenseTrackerApi.model.User;
import com.example.ExpenseTrackerApi.repo.iAuthRepo;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {

    @Autowired
    private iAuthRepo authRepo ;

    public void save(AuthenticationToken token) {

        authRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {

        return authRepo.findByUser(user);
    }
}
