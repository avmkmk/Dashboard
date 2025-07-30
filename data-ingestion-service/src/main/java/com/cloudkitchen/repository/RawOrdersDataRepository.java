package com.cloudkitchen.repository;

import com.cloudkitchen.model.RawOrdersData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for `RawOrdersData` entities.
 * Extends `JpaRepository` to provide standard CRUD operations
 * and custom query capabilities for `RawOrdersData`.
 */
public interface RawOrdersDataRepository extends JpaRepository<RawOrdersData, Long> {
}
