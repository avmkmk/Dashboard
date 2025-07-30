package com.cloudkitchen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Represents raw items data ingested from CSV files.
 * This entity maps to the `raw_items_data` table in the database.
 */
@Entity
@Table(name = "raw_items_data")
public class RawItemsData {

    /**
     * Unique identifier for the raw item data record.
     * This is an auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The date of the item record.
     */
    private Timestamp date;
    /**
     * The timestamp of the item record.
     */
    private Timestamp timestamp;

    /**
     * The invoice number associated with the item.
     */
    @Column(name = "invoice_no")
    private String invoiceNo;

    /**
     * The name of the item.
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * The quantity of the item.
     */
    private Integer qty;
    /**
     * The tax applied to the item.
     */
    private BigDecimal tax;
    /**
     * The variation of the item (e.g., size, flavor).
     */
    private String variation;
    /**
     * The category of the item.
     */
    private String category;

    /**
     * The original raw line from the CSV file, stored for debugging or reprocessing.
     */
    @Column(name = "raw_line", columnDefinition = "TEXT")
    private String rawLine;

    /**
     * Returns the unique identifier of the raw item data record.
     * @return The ID of the record.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the raw item data record.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the date of the item record.
     * @return The date of the record.
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Sets the date of the item record.
     * @param date The date to set.
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Returns the timestamp of the item record.
     * @return The timestamp of the record.
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp of the item record.
     * @param timestamp The timestamp to set.
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Returns the invoice number associated with the item.
     * @return The invoice number.
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets the invoice number associated with the item.
     * @param invoiceNo The invoice number to set.
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * Returns the name of the item.
     * @return The item name.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the name of the item.
     * @param itemName The item name to set.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Returns the quantity of the item.
     * @return The quantity.
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * Sets the quantity of the item.
     * @param qty The quantity to set.
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * Returns the tax applied to the item.
     * @return The tax amount.
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * Sets the tax applied to the item.
     * @param tax The tax amount to set.
     */
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    /**
     * Returns the variation of the item.
     * @return The item variation.
     */
    public String getVariation() {
        return variation;
    }

    /**
     * Sets the variation of the item.
     * @param variation The item variation to set.
     */
    public void setVariation(String variation) {
        this.variation = variation;
    }

    /**
     * Returns the category of the item.
     * @return The item category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the item.
     * @param category The item category to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the original raw line from the CSV file.
     * @return The raw CSV line.
     */
    public String getRawLine() {
        return rawLine;
    }

    /**
     * Sets the original raw line from the CSV file.
     * @param rawLine The raw CSV line to set.
     */
    public void setRawLine(String rawLine) {
        this.rawLine = rawLine;
    }
}
