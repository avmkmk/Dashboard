package com.cloudkitchen.listener;

import com.cloudkitchen.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for triggering analytics processing.
 * This controller provides an endpoint to manually initiate the calculation
 * and aggregation of analytics data.
 */
@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    /**
     * Autowired instance of `AnalyticsService` to perform the analytics processing.
     */
    @Autowired
    private AnalyticsService analyticsService;

    /**
     * Handles the POST request to trigger the analytics processing.
     * Calls the `processAnalytics` method of the `AnalyticsService`.
     *
     * @return A `ResponseEntity` indicating that analytics processing has started.
     */
    @PostMapping("/process")
    public ResponseEntity<String> processAnalytics() {
        analyticsService.processAnalytics();
        return ResponseEntity.ok("Analytics processing started.");
    }
}
