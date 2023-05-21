package com.example.ExpenseTrackerApi.repo;

import com.example.ExpenseTrackerApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepo extends JpaRepository<User,Integer> {


    User findFirstByUserEmail(String userEmail);
}
