package com.cloudkitchen.controller;

import com.cloudkitchen.service.DataIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * REST controller for handling data ingestion related API requests.
 * This controller provides endpoints for uploading CSV files containing
 * items reports and orders reports.
 */
@RestController
@RequestMapping("/api/raw-data")
public class DataIngestionController {

    /**
     * Autowired instance of `DataIngestionService` to handle the business logic
     * for processing and storing ingested data.
     */
    @Autowired
    private DataIngestionService dataIngestionService;

    /**
     * Handles the POST request for uploading an items report CSV file.
     * The file is processed by the `DataIngestionService`.
     *
     * @param file The `MultipartFile` representing the uploaded CSV file.
     * @return A `ResponseEntity` indicating the success or failure of the upload.
     *         - `HttpStatus.OK` with a success message if the file is processed successfully.
     *         - `HttpStatus.BAD_REQUEST` if no file is selected.
     *         - `HttpStatus.INTERNAL_SERVER_ERROR` if an error occurs during processing.
     */
    @PostMapping("/items-report")
    public ResponseEntity<String> uploadItemsReport(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }

        try {
            int recordsProcessed = dataIngestionService.processItemsReport(file);
            return new ResponseEntity<>("Items report uploaded and processed successfully. Records processed: " + recordsProcessed, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload items report: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Handles the POST request for uploading an orders report CSV file.
     * The file is processed by the `DataIngestionService`.
     *
     * @param file The `MultipartFile` representing the uploaded CSV file.
     * @return A `ResponseEntity` indicating the success or failure of the upload.
     *         - `HttpStatus.OK` with a success message if the file is processed successfully.
     *         - `HttpStatus.BAD_REQUEST` if no file is selected.
     *         - `HttpStatus.INTERNAL_SERVER_ERROR` if an error occurs during processing.
     */
    @PostMapping("/orders-report")
    public ResponseEntity<String> uploadOrdersReport(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }

        try {
            int recordsProcessed = dataIngestionService.processOrdersReport(file);
            return new ResponseEntity<>("Orders report uploaded and processed successfully. Records processed: " + recordsProcessed, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload orders report: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
