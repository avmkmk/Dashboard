package com.cloudkitchen.service.impl;

import com.cloudkitchen.model.RawItemsData;
import com.cloudkitchen.model.RawOrdersData;
import com.cloudkitchen.repository.RawItemsDataRepository;
import com.cloudkitchen.repository.RawOrdersDataRepository;
import com.cloudkitchen.service.DataIngestionService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the `DataIngestionService` interface.
 * This service handles the parsing of CSV files and persistence of raw data
 * into the database.
 */
@Service
public class DataIngestionServiceImpl implements DataIngestionService {

    /**
     * Repository for `RawItemsData` entities, used for database operations.
     */
    @Autowired
    private RawItemsDataRepository rawItemsDataRepository;

    /**
     * Repository for `RawOrdersData` entities, used for database operations.
     */
    @Autowired
    private RawOrdersDataRepository rawOrdersDataRepository;

    /**
     * DateTimeFormatter for parsing date and timestamp strings from CSV files.
     * The expected format is "yyyy-MM-dd HH:mm:ss".
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Processes an uploaded items report CSV file.
     * Reads the file, parses each record, maps it to a `RawItemsData` entity,
     * and saves all entities to the database in a batch.
     *
     * @param file The `MultipartFile` representing the items report CSV.
     * @return The number of records successfully processed and saved.
     * @throws IOException If an I/O error occurs during file reading.
     */
    @Override
    public int processItemsReport(MultipartFile file) throws IOException {
        // Use try-with-resources to ensure the BufferedReader is closed automatically.
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            // Configure CSVParser to read with headers, ignore header case, and trim whitespace.
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<RawItemsData> items = new ArrayList<>();
            // Iterate over each record in the CSV file.
            for (CSVRecord csvRecord : csvParser) {
                RawItemsData item = new RawItemsData();
                // Map CSV record fields to RawItemsData entity attributes.
                item.setDate(Timestamp.valueOf(LocalDateTime.parse(csvRecord.get("Date"), FORMATTER)));
                item.setTimestamp(Timestamp.valueOf(LocalDateTime.parse(csvRecord.get("Timestamp"), FORMATTER)));
                item.setInvoiceNo(csvRecord.get("Invoice No."));
                item.setItemName(csvRecord.get("Item Name"));
                item.setQty(Integer.parseInt(csvRecord.get("Qty.")));
                item.setTax(new BigDecimal(csvRecord.get("Tax")));
                item.setVariation(csvRecord.get("Variation"));
                item.setCategory(csvRecord.get("Category"));
                item.setRawLine(csvRecord.toString()); // Store the original raw line for debugging.
                items.add(item);
            }
            // Save all processed items to the database in a single batch operation.
            rawItemsDataRepository.saveAll(items);
            return items.size(); // Return the count of processed records.
        }
    }

    /**
     * Processes an uploaded orders report CSV file.
     * Reads the file, parses each record, maps it to a `RawOrdersData` entity,
     * and saves all entities to the database in a batch.
     *
     * @param file The `MultipartFile` representing the orders report CSV.
     * @return The number of records successfully processed and saved.
     * @throws IOException If an I/O error occurs during file reading.
     */
    @Override
    public int processOrdersReport(MultipartFile file) throws IOException {
        // Use try-with-resources to ensure the BufferedReader is closed automatically.
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            // Configure CSVParser to read with headers, ignore header case, and trim whitespace.
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<RawOrdersData> orders = new ArrayList<>();
            // Iterate over each record in the CSV file.
            for (CSVRecord csvRecord : csvParser) {
                RawOrdersData order = new RawOrdersData();
                // Map CSV record fields to RawOrdersData entity attributes.
                order.setInvoiceNo(csvRecord.get("Invoice No."));
                order.setDate(Timestamp.valueOf(LocalDateTime.parse(csvRecord.get("Date"), FORMATTER)));
                // Assuming Timestamp is optional or can be derived if not present in CSV
                // For now, setting it to current time if not explicitly in CSV or if format differs
                // LLD specifies Timestamp, so assuming it's present and in the same format as Date.
                order.setTimestamp(Timestamp.valueOf(LocalDateTime.parse(csvRecord.get("Timestamp"), FORMATTER)));
                order.setPaymentType(csvRecord.get("Payment Type"));
                order.setOrderType(csvRecord.get("Order Type"));
                order.setArea(csvRecord.get("Area"));
                order.setSubOrderType(csvRecord.get("Sub Order Type"));
                order.setPhone(csvRecord.get("Phone"));
                order.setName(csvRecord.get("Name"));
                order.setMyAmount(new BigDecimal(csvRecord.get("My Amount (₹)")));
                order.setDiscount(new BigDecimal(csvRecord.get("Discount (₹)")));
                order.setNetSales(new BigDecimal(csvRecord.get("Net Sales (₹)(M.A - D)")));
                order.setContainerCharge(new BigDecimal(csvRecord.get("Container Charge")));
                order.setTotalTax(new BigDecimal(csvRecord.get("Total Tax (₹)")));
                order.setTotalAmount(new BigDecimal(csvRecord.get("Total (₹)")));
                order.setRawLine(csvRecord.toString()); // Store the original raw line for debugging.
                orders.add(order);
            }
            // Save all processed orders to the database in a single batch operation.
            rawOrdersDataRepository.saveAll(orders);
            return orders.size(); // Return the count of processed records.
        }
    }
}
