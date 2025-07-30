package com.cloudkitchen.repository;

import com.cloudkitchen.model.WeeklyKpis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

/**
 * Repository interface for `WeeklyKpis` entities.
 * Extends `JpaRepository` to provide standard CRUD operations
 * and custom query capabilities for `WeeklyKpis`.
 */
public interface WeeklyKpisRepository extends JpaRepository<WeeklyKpis, Long> {
    /**
     * Finds a `WeeklyKpis` record by its week start date.
     * @param weekStartDate The week start date to search for.
     * @return An `Optional` containing the `WeeklyKpis` record if found, or empty otherwise.
     */
    Optional<WeeklyKpis> findByWeekStartDate(Date weekStartDate);
}
