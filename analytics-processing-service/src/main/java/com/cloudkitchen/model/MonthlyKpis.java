package com.cloudkitchen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents monthly Key Performance Indicators (KPIs) for cloud kitchen analytics.
 * This entity stores aggregated monthly metrics such as total revenue.
 */
@Entity
@Table(name = "monthly_kpis", schema = "analytics_schema")
public class MonthlyKpis {

    /**
     * Unique identifier for the monthly KPI record.
     * This is an auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The start date of the month for which the KPIs are reported.
     * This field is unique to ensure only one monthly KPI record per month.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "month_start_date", unique = true)
    private Date monthStartDate;

    /**
     * The total revenue generated for the month.
     */
    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

    // Other aggregated metrics can be added here as needed.

    /**
     * Returns the unique identifier of the monthly KPI record.
     * @return The ID of the record.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the monthly KPI record.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the start date of the month for the monthly KPIs.
     * @return The month start date.
     */
    public Date getMonthStartDate() {
        return monthStartDate;
    }

    /**
     * Sets the start date of the month for the monthly KPIs.
     * @param monthStartDate The month start date to set.
     */
    public void setMonthStartDate(Date monthStartDate) {
        this.monthStartDate = monthStartDate;
    }

    /**
     * Returns the total revenue for the month.
     * @return The total revenue.
     */
    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * Sets the total revenue for the month.
     * @param totalRevenue The total revenue to set.
     */
    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
