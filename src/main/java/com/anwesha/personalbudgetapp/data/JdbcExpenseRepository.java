package com.anwesha.personalbudgetapp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcExpenseRepository implements ExpenseRepository{
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcExpenseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public ExpenseEntry save(ExpenseEntry expenseEntry){
        jdbc.update(
                "INSERT INTO ExpenseEntry (Description, Category, Amount) values (?, ?, ?)",
                expenseEntry.getDescription(),
                expenseEntry.getCategory(),
                expenseEntry.getAmount());
        return expenseEntry;
    }
}
