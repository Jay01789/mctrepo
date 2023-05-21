package com.example.ExpenseTrackerApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
    @NotEmpty
    @NotNull
    private String userName;

    @Email
    private String userEmail ;
    private String userPassword;
}
