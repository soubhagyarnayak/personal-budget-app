package com.anwesha.personalbudgetapp;

import com.anwesha.personalbudgetapp.data.ExpenseEntry;
import com.anwesha.personalbudgetapp.data.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @PutMapping("/")
    public ExpenseEntry Save(ExpenseEntry expenseEntry) {
        return expenseRepository.save(expenseEntry);
    }
}
