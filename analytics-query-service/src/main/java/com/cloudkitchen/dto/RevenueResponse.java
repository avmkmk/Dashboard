package com.cloudkitchen.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data Transfer Object (DTO) for encapsulating revenue-related response data.
 * This class is used to send aggregated revenue information to clients.
 */
public class RevenueResponse {
    /**
     * The date associated with the revenue data (e.g., daily, weekly, or monthly start date).
     */
    private Date date;
    /**
     * The total revenue for the specified period.
     */
    private BigDecimal totalRevenue;
    // Add other fields as needed based on LLD

    /**
     * Constructs a new `RevenueResponse` with the specified date and total revenue.
     * @param date The date of the revenue data.
     * @param totalRevenue The total revenue amount.
     */
    public RevenueResponse(Date date, BigDecimal totalRevenue) {
        this.date = date;
        this.totalRevenue = totalRevenue;
    }

    /**
     * Returns the date associated with the revenue data.
     * @return The date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date associated with the revenue data.
     * @param date The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the total revenue for the specified period.
     * @return The total revenue.
     */
    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * Sets the total revenue for the specified period.
     * @param totalRevenue The total revenue to set.
     */
    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
