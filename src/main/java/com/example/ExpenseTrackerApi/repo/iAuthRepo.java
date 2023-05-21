package com.example.ExpenseTrackerApi.repo;

import com.example.ExpenseTrackerApi.model.AuthenticationToken;
import com.example.ExpenseTrackerApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iAuthRepo  extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByUser(User user);
}
