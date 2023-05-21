package com.example.ExpenseTrackerApi.service;

import com.example.ExpenseTrackerApi.model.Expense;
import com.example.ExpenseTrackerApi.model.User;
import com.example.ExpenseTrackerApi.repo.iExpenseRepo;
import com.example.ExpenseTrackerApi.repo.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private iExpenseRepo expenseRepo ;

    @Autowired
    private iUserRepo userRepo ;
    public void addExpense(Expense expense) {

        User user  = userRepo.findById(expense.getUser().getUser_id()).get();

        if(user == null){
            throw new IllegalStateException("User doest exist /provid vaild User");
        }

        expense.setUser(user);

        expenseRepo.save(expense);

    }

    public List<Expense> getByDate(LocalDate date) {
        List<Expense> allexpense = expenseRepo.findAll() ;

            List<Expense> returnExp = new ArrayList<>();
            for(Expense exp: allexpense){
                if(exp.getDate().equals(date)){
                    returnExp.add(exp);
                }
            }
            return returnExp;
    }

    public String getTotalExpenseByMonth(String name , Month month) {
        List<Expense> allexpense = expenseRepo.findAll() ;
        Double TotalExpense = 0.0 ;

        for(Expense exp:allexpense){
            if(exp.getUser().getUser_name().equals(name) && exp.getDate().getMonth().equals(month)){
                TotalExpense = TotalExpense+exp.getPrice();
            }
        }

        return "Hello" + " " + name + " " + "Your Total Expense for the Month of " +  " " +
                month +  " " + "is" + " " + TotalExpense ;
    }

    public String updateExpenseById(Integer id, Expense expense) {
         Expense expense1 = expenseRepo.findById(id).get();
         if(expense1 == null){
             throw new IllegalStateException("Invalid Expense Id , Please provide correct ExpenseId");
         }
         expense1.setTitle(expense.getTitle());
         expense1.setDescription(expense.getDescription());
         expense1.setPrice(expense.getPrice());
         expense1.setDate(expense.getDate());

         expenseRepo.save(expense1);

         return "Update Scussesfull";

    }

    public List<Expense> getAllByName(String name) {
        List<Expense> allexpense = expenseRepo.findAll() ;

        List<Expense> returnExp = new ArrayList<>();
        for(Expense exp: allexpense){
            if(exp.getUser().getUser_name().equals(name) ){
                returnExp.add(exp);
            }
        }
        return returnExp ;
    }

    public String deleteById(Integer expenseId) {

        expenseRepo.deleteById(expenseId);
        return  "Product Delete Scussesfully" ;
    }
}
