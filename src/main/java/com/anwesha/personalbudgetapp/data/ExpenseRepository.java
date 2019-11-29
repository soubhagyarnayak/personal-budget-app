package com.anwesha.personalbudgetapp.data;


public interface ExpenseRepository {
    
	ExpenseEntry save(ExpenseEntry expenseEntry);
    
	Iterable<ExpenseEntry> getExpenseEntriesForTimeRange(long startTimeEpoch, long endTimeEpoch);
}
