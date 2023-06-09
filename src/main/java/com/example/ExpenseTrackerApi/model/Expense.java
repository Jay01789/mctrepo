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


    @Column(nullable = false)
    private String title ;
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user ;

}
