package com.cloudkitchen.controller;

import com.cloudkitchen.dto.RevenueResponse;
import com.cloudkitchen.model.DailyKpis;
import com.cloudkitchen.model.MonthlyKpis;
import com.cloudkitchen.model.WeeklyKpis;
import com.cloudkitchen.service.AnalyticsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for querying analytics data.
 * This controller provides endpoints to retrieve daily, weekly, and monthly revenue KPIs.
 */
@RestController
@RequestMapping("/api/analytics")
public class AnalyticsQueryController {

    /**
     * Autowired instance of `AnalyticsQueryService` to handle the business logic
     * for retrieving analytics data.
     */
    @Autowired
    private AnalyticsQueryService analyticsQueryService;

    /**
     * Retrieves daily revenue data for a specific date.
     *
     * @param date The date for which to retrieve daily revenue, in "yyyy-MM-dd" format.
     * @return A `ResponseEntity` containing the `RevenueResponse` for the specified date
     *         if found, or `HttpStatus.NOT_FOUND` if no data is available.
     */
    @GetMapping("/revenue/daily")
    public ResponseEntity<RevenueResponse> getDailyRevenue(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Optional<DailyKpis> dailyKpis = analyticsQueryService.getDailyKpis(date);
        return dailyKpis.map(kpis -> new RevenueResponse(kpis.getReportDate(), kpis.getTotalRevenue()))
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves weekly revenue data within a specified date range.
     *
     * @param startDate The start date of the range (inclusive), in "yyyy-MM-dd" format.
     * @param endDate The end date of the range (inclusive), in "yyyy-MM-dd" format.
     * @return A `ResponseEntity` containing a list of `RevenueResponse` objects for the
     *         weekly revenue within the specified range.
     */
    @GetMapping("/revenue/weekly")
    public ResponseEntity<List<RevenueResponse>> getWeeklyRevenue(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<WeeklyKpis> weeklyKpis = analyticsQueryService.getWeeklyKpis(startDate, endDate);
        List<RevenueResponse> response = weeklyKpis.stream()
                .map(kpis -> new RevenueResponse(kpis.getWeekStartDate(), kpis.getTotalRevenue()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Retrieves monthly revenue data within a specified date range.
     *
     * @param startDate The start date of the range (inclusive), in "yyyy-MM-dd" format.
     * @param endDate The end date of the range (inclusive), in "yyyy-MM-dd" format.
     * @return A `ResponseEntity` containing a list of `RevenueResponse` objects for the
     *         monthly revenue within the specified range.
     */
    @GetMapping("/revenue/monthly")
    public ResponseEntity<List<RevenueResponse>> getMonthlyRevenue(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<MonthlyKpis> monthlyKpis = analyticsQueryService.getMonthlyKpis(startDate, endDate);
        List<RevenueResponse> response = monthlyKpis.stream()
                .map(kpis -> new RevenueResponse(kpis.getMonthStartDate(), kpis.getTotalRevenue()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}