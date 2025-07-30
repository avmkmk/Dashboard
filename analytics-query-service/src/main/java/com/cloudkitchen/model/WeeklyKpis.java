package com.cloudkitchen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents weekly Key Performance Indicators (KPIs) for cloud kitchen analytics.
 * This entity stores aggregated weekly metrics such as total revenue.
 */
@Entity
@Table(name = "weekly_kpis", schema = "analytics_schema")
public class WeeklyKpis {

    /**
     * Unique identifier for the weekly KPI record.
     * This is an auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The start date of the week for which the KPIs are reported.
     * This field is unique to ensure only one weekly KPI record per week.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "week_start_date", unique = true)
    private Date weekStartDate;

    /**
     * The total revenue generated for the week.
     */
    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

    // Other aggregated metrics can be added here as needed.

    /**
     * Returns the unique identifier of the weekly KPI record.
     * @return The ID of the record.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the weekly KPI record.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the start date of the week for the weekly KPIs.
     * @return The week start date.
     */
    public Date getWeekStartDate() {
        return weekStartDate;
    }

    /**
     * Sets the start date of the week for the weekly KPIs.
     * @param weekStartDate The week start date to set.
     */
    public void setWeekStartDate(Date weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    /**
     * Returns the total revenue for the week.
     * @return The total revenue.
     */
    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * Sets the total revenue for the week.
     * @param totalRevenue The total revenue to set.
     */
    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
