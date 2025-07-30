package com.cloudkitchen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Represents daily Key Performance Indicators (KPIs) for cloud kitchen analytics.
 * This entity stores aggregated daily metrics such as revenue, order counts, and customer data.
 */
@Entity
@Table(name = "daily_kpis", schema = "analytics_schema")
public class DailyKpis {

    /**
     * Unique identifier for the daily KPI record.
     * This is an auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The date for which the KPIs are reported.
     * This field is unique to ensure only one daily KPI record per day.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "report_date", unique = true)
    private Date reportDate;

    /**
     * The total revenue generated for the day.
     */
    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

    /**
     * Revenue specifically from Zomato orders for the day.
     */
    @Column(name = "aggregator_revenue_zomato")
    private BigDecimal aggregatorRevenueZomato;

    /**
     * Revenue specifically from Swiggy orders for the day.
     */
    @Column(name = "aggregator_revenue_swiggy")
    private BigDecimal aggregatorRevenueSwiggy;

    /**
     * Revenue specifically from pickup orders for the day.
     */
    @Column(name = "aggregator_revenue_pickup")
    private BigDecimal aggregatorRevenuePickup;

    /**
     * Estimated commission paid to aggregators for the day.
     */
    @Column(name = "estimated_aggregator_commission")
    private BigDecimal estimatedAggregatorCommission;

    /**
     * Total food cost for the day.
     */
    @Column(name = "total_food_cost")
    private BigDecimal totalFoodCost;

    /**
     * Estimated wastage amount for the day.
     */
    @Column(name = "estimated_wastage_amount")
    private BigDecimal estimatedWastageAmount;

    /**
     * Total number of orders for the day.
     */
    @Column(name = "total_order_count")
    private Integer totalOrderCount;

    /**
     * Number of new customers acquired on this day.
     */
    @Column(name = "new_customer_count")
    private Integer newCustomerCount;

    /**
     * Number of repeat customers on this day.
     */
    @Column(name = "repeat_customer_count")
    private Integer repeatCustomerCount;

    /**
     * Timestamp indicating when this record was last updated.
     */
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    /**
     * Returns the unique identifier of the daily KPI record.
     * @return The ID of the record.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the daily KPI record.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the report date for the daily KPIs.
     * @return The report date.
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * Sets the report date for the daily KPIs.
     * @param reportDate The report date to set.
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * Returns the total revenue for the day.
     * @return The total revenue.
     */
    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * Sets the total revenue for the day.
     * @param totalRevenue The total revenue to set.
     */
    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    /**
     * Returns the aggregator revenue from Zomato for the day.
     * @return The Zomato revenue.
     */
    public BigDecimal getAggregatorRevenueZomato() {
        return aggregatorRevenueZomato;
    }

    /**
     * Sets the aggregator revenue from Zomato for the day.
     * @param aggregatorRevenueZomato The Zomato revenue to set.
     */
    public void setAggregatorRevenueZomato(BigDecimal aggregatorRevenueZomato) {
        this.aggregatorRevenueZomato = aggregatorRevenueZomato;
    }

    /**
     * Returns the aggregator revenue from Swiggy for the day.
     * @return The Swiggy revenue.
     */
    public BigDecimal getAggregatorRevenueSwiggy() {
        return aggregatorRevenueSwiggy;
    }

    /**
     * Sets the aggregator revenue from Swiggy for the day.
     * @param aggregatorRevenueSwiggy The Swiggy revenue to set.
     */
    public void setAggregatorRevenueSwiggy(BigDecimal aggregatorRevenueSwiggy) {
        this.aggregatorRevenueSwiggy = aggregatorRevenueSwiggy;
    }

    /**
     * Returns the aggregator revenue from pickup orders for the day.
     * @return The pickup revenue.
     */
    public BigDecimal getAggregatorRevenuePickup() {
        return aggregatorRevenuePickup;
    }

    /**
     * Sets the aggregator revenue from pickup orders for the day.
     * @param aggregatorRevenuePickup The pickup revenue to set.
     */
    public void setAggregatorRevenuePickup(BigDecimal aggregatorRevenuePickup) {
        this.aggregatorRevenuePickup = aggregatorRevenuePickup;
    }

    /**
     * Returns the estimated aggregator commission for the day.
     * @return The estimated commission.
     */
    public BigDecimal getEstimatedAggregatorCommission() {
        return estimatedAggregatorCommission;
    }

    /**
     * Sets the estimated aggregator commission for the day.
     * @param estimatedAggregatorCommission The estimated commission to set.
     */
    public void setEstimatedAggregatorCommission(BigDecimal estimatedAggregatorCommission) {
        this.estimatedAggregatorCommission = estimatedAggregatorCommission;
    }

    /**
     * Returns the total food cost for the day.
     * @return The total food cost.
     */
    public BigDecimal getTotalFoodCost() {
        return totalFoodCost;
    }

    /**
     * Sets the total food cost for the day.
     * @param totalFoodCost The total food cost to set.
     */
    public void setTotalFoodCost(BigDecimal totalFoodCost) {
        this.totalFoodCost = totalFoodCost;
    }

    /**
     * Returns the estimated wastage amount for the day.
     * @return The estimated wastage amount.
     */
    public BigDecimal getEstimatedWastageAmount() {
        return estimatedWastageAmount;
    }

    /**
     * Sets the estimated wastage amount for the day.
     * @param estimatedWastageAmount The estimated wastage amount to set.
     */
    public void setEstimatedWastageAmount(BigDecimal estimatedWastageAmount) {
        this.estimatedWastageAmount = estimatedWastageAmount;
    }

    /**
     * Returns the total number of orders for the day.
     * @return The total order count.
     */
    public Integer getTotalOrderCount() {
        return totalOrderCount;
    }

    /**
     * Sets the total number of orders for the day.
     * @param totalOrderCount The total order count to set.
     */
    public void setTotalOrderCount(Integer totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    /**
     * Returns the number of new customers acquired on this day.
     * @return The new customer count.
     */
    public Integer getNewCustomerCount() {
        return newCustomerCount;
    }

    /**
     * Sets the number of new customers acquired on this day.
     * @param newCustomerCount The new customer count to set.
     */
    public void setNewCustomerCount(Integer newCustomerCount) {
        this.newCustomerCount = newCustomerCount;
    }

    /**
     * Returns the number of repeat customers on this day.
     * @return The repeat customer count.
     */
    public Integer getRepeatCustomerCount() {
        return repeatCustomerCount;
    }

    /**
     * Sets the number of repeat customers on this day.
     * @param repeatCustomerCount The repeat customer count to set.
     */
    public void setRepeatCustomerCount(Integer repeatCustomerCount) {
        this.repeatCustomerCount = repeatCustomerCount;
    }

    /**
     * Returns the timestamp indicating when this record was last updated.
     * @return The last updated timestamp.
     */
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the timestamp indicating when this record was last updated.
     * @param lastUpdated The last updated timestamp to set.
     */
    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
