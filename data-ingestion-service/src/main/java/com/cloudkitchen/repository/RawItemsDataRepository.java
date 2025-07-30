package com.cloudkitchen.repository;

import com.cloudkitchen.model.RawItemsData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for `RawItemsData` entities.
 * Extends `JpaRepository` to provide standard CRUD operations
 * and custom query capabilities for `RawItemsData`.
 */
public interface RawItemsDataRepository extends JpaRepository<RawItemsData, Long> {
}
