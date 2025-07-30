package com.cloudkitchen.service;

/**
 * Service interface for triggering analytics processing.
 * Defines the contract for services that perform calculations
 * and aggregation of raw data into KPIs.
 */
public interface AnalyticsService {
    /**
     * Initiates the process of calculating and aggregating analytics data.
     * This method typically fetches raw data, performs various KPI calculations,
     * and persists the results into the analytics database.
     */
    void processAnalytics();
}
