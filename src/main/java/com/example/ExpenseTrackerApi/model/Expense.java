package com.example.ExpenseTrackerApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId ;

    @NotEmpty
    private String title ;

    @NotEmpty
    private String description;

    @NotEmpty
    private Double price;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user ;

}
