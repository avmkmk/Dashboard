package com.cloudkitchen.repository;

import com.cloudkitchen.model.MonthlyKpis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for `MonthlyKpis` entities in the analytics query service.
 * Extends `JpaRepository` to provide standard CRUD operations
 * and custom query capabilities for `MonthlyKpis`.
 */
public interface MonthlyKpisRepository extends JpaRepository<MonthlyKpis, Long> {
    /**
     * Finds a `MonthlyKpis` record by its month start date.
     * @param monthStartDate The month start date to search for.
     * @return An `Optional` containing the `MonthlyKpis` record if found, or empty otherwise.
     */
    Optional<MonthlyKpis> findByMonthStartDate(Date monthStartDate);

    /**
     * Finds a list of `MonthlyKpis` records within a specified date range.
     * @param startDate The start date of the range (inclusive).
     * @param endDate The end date of the range (inclusive).
     * @return A list of `MonthlyKpis` records within the specified date range.
     */
    List<MonthlyKpis> findByMonthStartDateBetween(Date startDate, Date endDate);
}
