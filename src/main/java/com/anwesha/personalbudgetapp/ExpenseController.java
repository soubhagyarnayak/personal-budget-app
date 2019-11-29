package com.anwesha.personalbudgetapp;

import com.anwesha.personalbudgetapp.data.ExpenseEntry;
import com.anwesha.personalbudgetapp.data.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api",produces="application/json")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @PostMapping("/expense")
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseEntry Save(@RequestBody ExpenseEntry expenseEntry) {
        return expenseRepository.save(expenseEntry);
    }
    
    @GetMapping("/expense")
    public Iterable<ExpenseEntry> GetExpenseEntries(long startTimeEpoch, long endTimeEpoch) {
    	return expenseRepository.getExpenseEntriesForTimeRange(startTimeEpoch, endTimeEpoch);
    }
    
}
