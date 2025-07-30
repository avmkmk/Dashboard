package com.cloudkitchen.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Service interface for handling data ingestion operations.
 * Defines methods for processing different types of raw data reports.
 */
public interface DataIngestionService {
    /**
     * Processes an uploaded items report CSV file.
     * Parses the file, extracts relevant data, and persists it.
     *
     * @param file The `MultipartFile` representing the items report CSV.
     * @return The number of records successfully processed.
     * @throws IOException If an I/O error occurs during file reading.
     */
    int processItemsReport(MultipartFile file) throws IOException;

    /**
     * Processes an uploaded orders report CSV file.
     * Parses the file, extracts relevant data, and persists it.
     *
     * @param file The `MultipartFile` representing the orders report CSV.
     * @return The number of records successfully processed.
     * @throws IOException If an I/O error occurs during file reading.
     */
    int processOrdersReport(MultipartFile file) throws IOException;
}
