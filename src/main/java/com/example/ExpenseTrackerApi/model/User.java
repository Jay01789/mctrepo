package com.example.ExpenseTrackerApi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String user_name;
    private String userEmail;
    private String user_password;

    public User(String user_name, String userEmail, String user_password) {
        this.user_name = user_name;
        this.userEmail = userEmail;
        this.user_password = user_password;
    }

}
