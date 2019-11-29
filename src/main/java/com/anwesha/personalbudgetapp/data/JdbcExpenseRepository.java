package com.anwesha.personalbudgetapp.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcExpenseRepository implements ExpenseRepository{
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcExpenseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public ExpenseEntry save(ExpenseEntry expenseEntry){
        jdbc.update(
                "INSERT INTO ExpenseEntry (Id, Description, Category, Amount, CreateTime, UpdateTime) values (?, ?, ?, ?, ?, ?)",
                expenseEntry.getId(),
                expenseEntry.getDescription(),
                expenseEntry.getCategory(),
                expenseEntry.getAmount(),
                GetDateTimeFromEpochSeconds(expenseEntry.getCreateTimeEpoch()),
                GetDateTimeFromEpochSeconds(expenseEntry.getUpdateTimeEpoch()));
        return expenseEntry;
    }
    
    public Iterable<ExpenseEntry> getExpenseEntriesForTimeRange(long startTimeEpoch, long endTimeEpoch){
    	return jdbc.query("SELECT Id, Description, Category, Amount, CreateTime, UpdateTime from ExpenseEntry",
    		      this::mapRowToIngredient);
    }
    
    private ExpenseEntry mapRowToIngredient(ResultSet rs, int rowNum)
    	    throws SQLException {
    	  return new ExpenseEntry(
    	      rs.getObject("Id",UUID.class),
    	      rs.getString("Description"),
    	      rs.getString("Category"),
    	      rs.getDouble("Amount"),
    	      rs.getTimestamp("CreateTime").getTime()/1000,
    	      rs.getTimestamp("UpdateTime").getTime()/1000);
    	}
    
    private static LocalDateTime GetDateTimeFromEpochSeconds(long epochSeconds) {
    	Instant instant = Instant.ofEpochSecond(epochSeconds);
    	return ZonedDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDateTime();
    }
}
