package com.example.ExpenseTrackerApi.controller;

import com.example.ExpenseTrackerApi.model.Expense;
import com.example.ExpenseTrackerApi.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService ;


    // Adding Expenses
    @PostMapping(value = "/add")
    public void addExpense(@Valid @RequestBody Expense expense)
    {
        expenseService.addExpense(expense);
    }


    //getting all products on a particular date
    @GetMapping(value = "/products/{date}")
    public List<Expense> getExpenseByDate(@PathVariable LocalDate date)
    {
        return expenseService.getByDate(date);
    }

    //getting Monthly expense report using user Name  and total expense of the month

    @GetMapping(value = "/total/expense/{name}/{month}")
    public String getTotalExpenseByMonth(@PathVariable String name , @PathVariable Month month)
    {
        return expenseService.getTotalExpenseByMonth(name ,month);
    }

    //updating the expense

    @PutMapping(value = "/update/expense/{id}")
    public String updateExpense(@PathVariable Integer id,@RequestBody Expense expense )
    {
      return   expenseService.updateExpenseById(id,expense);
    }

    //getting all expenses using name

    @GetMapping(value = "get/expense/{name}")
    public List<Expense> getAllByName(@PathVariable String name){
        return expenseService.getAllByName(name);
    }

    @DeleteMapping(value = "/delete/{expenseId}")
    public String deleteByName(@PathVariable Integer expenseId)
    {
      return   expenseService.deleteById(expenseId);
    }


}
