package com.anwesha.personalbudgetapp.data;

import java.util.UUID;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExpenseEntry {
    private final UUID id;
    private final String description;
    private final String category;
    private final double amount;
    private final long createTimeEpoch;
    private final long updateTimeEpoch;
}
