package com.example.ExpenseTrackerApi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer token_id ;
    private LocalDate tokenCreationDate;
    private String token;

    @OneToOne
    @JoinColumn(nullable = false,name = "fk_user_ID")
    private User user ;

    public AuthenticationToken(User user) {

        this.user = user ;
        this.tokenCreationDate = LocalDate.now() ;
        this.token = UUID.randomUUID().toString();
    }



}
