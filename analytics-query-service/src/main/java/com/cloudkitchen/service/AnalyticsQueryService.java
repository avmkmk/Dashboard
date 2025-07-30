package com.cloudkitchen.service;

import com.cloudkitchen.model.DailyKpis;
import com.cloudkitchen.model.MonthlyKpis;
import com.cloudkitchen.model.WeeklyKpis;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for querying analytics data.
 * Defines methods for retrieving daily, weekly, and monthly KPIs.
 */
public interface AnalyticsQueryService {
    /**
     * Retrieves daily Key Performance Indicators (KPIs) for a specific date.
     * @param date The date for which to retrieve daily KPIs.
     * @return An `Optional` containing the `DailyKpis` record if found, or empty otherwise.
     */
    Optional<DailyKpis> getDailyKpis(Date date);

    /**
     * Retrieves a list of weekly Key Performance Indicators (KPIs) within a specified date range.
     * @param startDate The start date of the range (inclusive).
     * @param endDate The end date of the range (inclusive).
     * @return A list of `WeeklyKpis` records within the specified date range.
     */
    List<WeeklyKpis> getWeeklyKpis(Date startDate, Date endDate);

    /**
     * Retrieves a list of monthly Key Performance Indicators (KPIs) within a specified date range.
     * @param startDate The start date of the range (inclusive).
     * @param endDate The end date of the range (inclusive).
     * @return A list of `MonthlyKpis` records within the specified date range.
     */
    List<MonthlyKpis> getMonthlyKpis(Date startDate, Date endDate);
}
