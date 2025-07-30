package com.cloudkitchen.repository;

import com.cloudkitchen.model.DailyKpis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

/**
 * Repository interface for `DailyKpis` entities in the analytics query service.
 * Extends `JpaRepository` to provide standard CRUD operations
 * and custom query capabilities for `DailyKpis`.
 */
public interface DailyKpisRepository extends JpaRepository<DailyKpis, Long> {
    /**
     * Finds a `DailyKpis` record by its report date.
     * @param reportDate The date to search for.
     * @return An `Optional` containing the `DailyKpis` record if found, or empty otherwise.
     */
    Optional<DailyKpis> findByReportDate(Date reportDate);
}
