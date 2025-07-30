package com.cloudkitchen.repository;

import com.cloudkitchen.model.MonthlyKpis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

/**
 * Repository interface for `MonthlyKpis` entities.
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
}
