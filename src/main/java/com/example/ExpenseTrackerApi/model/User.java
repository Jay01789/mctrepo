package com.example.ExpenseTrackerApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty
    @NotNull
    private String user_name;

    @Email
    private String userEmail;
    private String user_password;

    public User(String user_name, String userEmail, String user_password) {
        this.user_name = user_name;
        this.userEmail = userEmail;
        this.user_password = user_password;
    }

}
