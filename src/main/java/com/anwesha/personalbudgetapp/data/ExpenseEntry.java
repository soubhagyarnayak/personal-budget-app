package com.anwesha.personalbudgetapp.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class ExpenseEntry {
    private long id;
    private String description;
    private String category;
    private double amount;
    private Date createTime;
    private Date updateTime;
}
