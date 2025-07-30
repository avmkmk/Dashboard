package com.cloudkitchen.service.impl;

import com.cloudkitchen.model.DailyKpis;
import com.cloudkitchen.model.MonthlyKpis;
import com.cloudkitchen.model.WeeklyKpis;
import com.cloudkitchen.repository.DailyKpisRepository;
import com.cloudkitchen.repository.MonthlyKpisRepository;
import com.cloudkitchen.repository.WeeklyKpisRepository;
import com.cloudkitchen.service.AnalyticsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the `AnalyticsQueryService` interface.
 * This service provides methods to retrieve daily, weekly, and monthly KPIs
 * from the respective repositories.
 */
@Service
public class AnalyticsQueryServiceImpl implements AnalyticsQueryService {

    /**
     * Repository for `DailyKpis` entities, used to fetch daily aggregated data.
     */
    @Autowired
    private DailyKpisRepository dailyKpisRepository;

    /**
     * Repository for `WeeklyKpis` entities, used to fetch weekly aggregated data.
     */
    @Autowired
    private WeeklyKpisRepository weeklyKpisRepository;

    /**
     * Repository for `MonthlyKpis` entities, used to fetch monthly aggregated data.
     */
    @Autowired
    private MonthlyKpisRepository monthlyKpisRepository;

    /**
     * Retrieves daily Key Performance Indicators (KPIs) for a specific date.
     * @param date The date for which to retrieve daily KPIs.
     * @return An `Optional` containing the `DailyKpis` record if found, or empty otherwise.
     */
    @Override
    public Optional<DailyKpis> getDailyKpis(Date date) {
        return dailyKpisRepository.findByReportDate(date);
    }

    /**
     * Retrieves a list of weekly Key Performance Indicators (KPIs) within a specified date range.
     * @param startDate The start date of the range (inclusive).
     * @param endDate The end date of the range (inclusive).
     * @return A list of `WeeklyKpis` records within the specified date range.
     */
    @Override
    public List<WeeklyKpis> getWeeklyKpis(Date startDate, Date endDate) {
        return weeklyKpisRepository.findByWeekStartDateBetween(startDate, endDate);
    }

    /**
     * Retrieves a list of monthly Key Performance Indicators (KPIs) within a specified date range.
     * @param startDate The start date of the range (inclusive).
     * @param endDate The end date of the range (inclusive).
     * @return A list of `MonthlyKpis` records within the specified date range.
     */
    @Override
    public List<MonthlyKpis> getMonthlyKpis(Date startDate, Date endDate) {
        return monthlyKpisRepository.findByMonthStartDateBetween(startDate, endDate);
    }
}
