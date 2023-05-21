package com.example.ExpenseTrackerApi.repo;

import com.example.ExpenseTrackerApi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iExpenseRepo  extends JpaRepository<Expense,Integer> {

}
