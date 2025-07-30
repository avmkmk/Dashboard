package com.cloudkitchen.service.impl;

import com.cloudkitchen.model.DailyKpis;
import com.cloudkitchen.model.RawOrdersData;
import com.cloudkitchen.model.WeeklyKpis;
import com.cloudkitchen.model.MonthlyKpis;
import com.cloudkitchen.repository.DailyKpisRepository;
import com.cloudkitchen.repository.MonthlyKpisRepository;
import com.cloudkitchen.repository.RawOrdersDataRepository;
import com.cloudkitchen.repository.WeeklyKpisRepository;
import com.cloudkitchen.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.YearMonth;
import java.time.DayOfWeek;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of the `AnalyticsService` interface.
 * This service is responsible for processing raw order data,
 * calculating various daily, weekly, and monthly Key Performance Indicators (KPIs),
 * and persisting these aggregated results into the database.
 */
@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    /**
     * Repository for `DailyKpis` entities, used for database operations related to daily aggregated data.
     */
    @Autowired
    private DailyKpisRepository dailyKpisRepository;

    /**
     * Repository for `WeeklyKpis` entities, used for database operations related to weekly aggregated data.
     */
    @Autowired
    private WeeklyKpisRepository weeklyKpisRepository;

    /**
     * Repository for `MonthlyKpis` entities, used for database operations related to monthly aggregated data.
     */
    @Autowired
    private MonthlyKpisRepository monthlyKpisRepository;

    /**
     * Repository for `RawOrdersData` entities, used to fetch raw order data for KPI calculations.
     */
    @Autowired
    private RawOrdersDataRepository rawOrdersDataRepository;

    /**
     * Processes raw order data to calculate and persist daily, weekly, and monthly KPIs.
     * This method fetches all raw order data, groups it by date, week, and month,
     * calculates total revenue for each period, and saves the results.
     * Future enhancements will include more detailed KPI calculations as per LLD.
     */
    @Override
    public void processAnalytics() {
        dailyKpisRepository.deleteAll();
        weeklyKpisRepository.deleteAll();
        monthlyKpisRepository.deleteAll();

        // Fetch all raw order data from the database.
        List<RawOrdersData> allOrders = rawOrdersDataRepository.findAll();

        // Group orders by date to calculate daily KPIs.
        Map<LocalDate, List<RawOrdersData>> ordersByDate = allOrders.stream()
                .collect(Collectors.groupingBy(order -> order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));

        // Iterate through daily grouped orders to calculate and save daily KPIs.
        ordersByDate.forEach((date, orders) -> {
            // Calculate total revenue for the current day.
            BigDecimal totalRevenue = orders.stream()
                    .map(RawOrdersData::getNetSales)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            // Retrieve existing DailyKpis for the date or create a new one.
            DailyKpis dailyKpis = dailyKpisRepository.findByReportDate(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                    .orElse(new DailyKpis());
            // Set report date, total revenue, and last updated timestamp.
            dailyKpis.setReportDate(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            dailyKpis.setTotalRevenue(totalRevenue);
            dailyKpis.setLastUpdated(new Timestamp(System.currentTimeMillis()));
            // Save the daily KPIs to the database.
            dailyKpisRepository.save(dailyKpis);
        });

        // Weekly KPI calculations: Group orders by the start of the week (Monday).
        Map<LocalDate, List<RawOrdersData>> ordersByWeek = allOrders.stream()
                .collect(Collectors.groupingBy(order -> {
                    LocalDate orderDate = order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    // Determine the Monday of the week for the given order date.
                    return orderDate.with(WeekFields.ISO.dayOfWeek(), DayOfWeek.MONDAY.getValue());
                }));

        // Iterate through weekly grouped orders to calculate and save weekly KPIs.
        ordersByWeek.forEach((weekStartDate, orders) -> {
            // Calculate total revenue for the current week.
            BigDecimal totalRevenue = orders.stream()
                    .map(RawOrdersData::getNetSales)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            // Retrieve existing WeeklyKpis for the week or create a new one.
            WeeklyKpis weeklyKpis = weeklyKpisRepository.findByWeekStartDate(Date.from(weekStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                    .orElse(new WeeklyKpis());
            // Set week start date and total revenue.
            weeklyKpis.setWeekStartDate(Date.from(weekStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            weeklyKpis.setTotalRevenue(totalRevenue);
            // Save the weekly KPIs to the database.
            weeklyKpisRepository.save(weeklyKpis);
        });

        // Monthly KPI calculations: Group orders by year and month.
        Map<YearMonth, List<RawOrdersData>> ordersByMonth = allOrders.stream()
                .collect(Collectors.groupingBy(order -> YearMonth.from(order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())));

        // Iterate through monthly grouped orders to calculate and save monthly KPIs.
        ordersByMonth.forEach((yearMonth, orders) -> {
            // Calculate total revenue for the current month.
            BigDecimal totalRevenue = orders.stream()
                    .map(RawOrdersData::getNetSales)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            // Retrieve existing MonthlyKpis for the month or create a new one.
            MonthlyKpis monthlyKpis = monthlyKpisRepository.findByMonthStartDate(Date.from(yearMonth.atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                    .orElse(new MonthlyKpis());
            // Set month start date and total revenue.
            monthlyKpis.setMonthStartDate(Date.from(yearMonth.atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            monthlyKpis.setTotalRevenue(totalRevenue);
            // Save the monthly KPIs to the database.
            monthlyKpisRepository.save(monthlyKpis);
        });
    }
}