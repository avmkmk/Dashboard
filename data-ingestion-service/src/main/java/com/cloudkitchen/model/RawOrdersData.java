package com.cloudkitchen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Represents raw orders data ingested from CSV files.
 * This entity maps to the `raw_orders_data` table in the database.
 */
@Entity
@Table(name = "raw_orders_data")
public class RawOrdersData {

    /**
     * Unique identifier for the raw order data record.
     * This is an auto-generated primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The invoice number associated with the order.
     */
    @Column(name = "invoice_no")
    private String invoiceNo;

    /**
     * The date of the order record.
     */
    private Timestamp date;
    /**
     * The timestamp of the order record.
     */
    private Timestamp timestamp;

    /**
     * The payment type used for the order.
     */
    @Column(name = "payment_type")
    private String paymentType;

    /**
     * The type of order (e.g., Delivery, Pick Up).
     */
    @Column(name = "order_type")
    private String orderType;

    /**
     * The geographical area of the order.
     */
    private String area;

    /**
     * The sub-type of the order.
     */
    @Column(name = "sub_order_type")
    private String subOrderType;

    /**
     * The phone number of the customer.
     */
    private String phone;
    /**
     * The name of the customer.
     */
    private String name;
    /**
     * The address of the customer.
     */
    private String address;

    /**
     * The amount of the order as recorded by the system.
     */
    @Column(name = "my_amount")
    private BigDecimal myAmount;

    /**
     * The discount applied to the order.
     */
    private BigDecimal discount;

    /**
     * The net sales amount after discounts.
     */
    @Column(name = "net_sales")
    private BigDecimal netSales;

    /**
     * The charge for the container.
     */
    @Column(name = "container_charge")
    private BigDecimal containerCharge;

    /**
     * The total tax applied to the order.
     */
    @Column(name = "total_tax")
    private BigDecimal totalTax;

    /**
     * The rounded-off amount for the order.
     */
    @Column(name = "round_off")
    private BigDecimal roundOff;

    /**
     * The total amount of the order.
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * The online tax calculated for the order.
     */
    @Column(name = "online_tax_calculated")
    private BigDecimal onlineTaxCalculated;

    /**
     * The GST paid by e-commerce platforms.
     */
    @Column(name = "gst_paid_by_ecommerce")
    private BigDecimal gstPaidByEcommerce;

    /**
     * The amount of CGST (Central Goods and Services Tax).
     */
    @Column(name = "amount_cgst")
    private BigDecimal amountCgst;

    /**
     * The CGST rate.
     */
    private BigDecimal cgst;

    /**
     * The amount of SGST (State Goods and Services Tax).
     */
    @Column(name = "amount_sgst")
    private BigDecimal amountSgst;

    /**
     * The SGST rate.
     */
    private BigDecimal sgst;

    /**
     * The original raw line from the CSV file, stored for debugging or reprocessing.
     */
    @Column(name = "raw_line", columnDefinition = "TEXT")
    private String rawLine;

    /**
     * Returns the unique identifier of the raw order data record.
     * @return The ID of the record.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the raw order data record.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the invoice number associated with the order.
     * @return The invoice number.
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets the invoice number associated with the order.
     * @param invoiceNo The invoice number to set.
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * Returns the date of the order record.
     * @return The date of the record.
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Sets the date of the order record.
     * @param date The date to set.
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Returns the timestamp of the order record.
     * @return The timestamp of the record.
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp of the order record.
     * @param timestamp The timestamp to set.
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Returns the payment type used for the order.
     * @return The payment type.
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the payment type used for the order.
     * @param paymentType The payment type to set.
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Returns the type of order.
     * @return The order type.
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the type of order.
     * @param orderType The order type to set.
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Returns the geographical area of the order.
     * @return The area.
     */
    public String getArea() {
        return area;
    }

    /**
     * Sets the geographical area of the order.
     * @param area The area to set.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Returns the sub-type of the order.
     * @return The sub-order type.
     */
    public String getSubOrderType() {
        return subOrderType;
    }

    /**
     * Sets the sub-type of the order.
     * @param subOrderType The sub-order type to set.
     */
    public void setSubOrderType(String subOrderType) {
        this.subOrderType = subOrderType;
    }

    /**
     * Returns the phone number of the customer.
     * @return The phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the customer.
     * @param phone The phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the name of the customer.
     * @return The customer name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     * @param name The customer name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the address of the customer.
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the amount of the order as recorded by the system.
     * @return The recorded amount.
     */
    public BigDecimal getMyAmount() {
        return myAmount;
    }

    /**
     * Sets the amount of the order as recorded by the system.
     * @param myAmount The recorded amount to set.
     */
    public void setMyAmount(BigDecimal myAmount) {
        this.myAmount = myAmount;
    }

    /**
     * Returns the discount applied to the order.
     * @return The discount amount.
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * Sets the discount applied to the order.
     * @param discount The discount amount to set.
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * Returns the net sales amount after discounts.
     * @return The net sales amount.
     */
    public BigDecimal getNetSales() {
        return netSales;
    }

    /**
     * Sets the net sales amount after discounts.
     * @param netSales The net sales amount to set.
     */
    public void setNetSales(BigDecimal netSales) {
        this.netSales = netSales;
    }

    /**
     * Returns the charge for the container.
     * @return The container charge.
     */
    public BigDecimal getContainerCharge() {
        return containerCharge;
    }

    /**
     * Sets the charge for the container.
     * @param containerCharge The container charge to set.
     */
    public void setContainerCharge(BigDecimal containerCharge) {
        this.containerCharge = containerCharge;
    }

    /**
     * Returns the total tax applied to the order.
     * @return The total tax amount.
     */
    public BigDecimal getTotalTax() {
        return totalTax;
    }

    /**
     * Sets the total tax applied to the order.
     * @param totalTax The total tax amount to set.
     */
    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    /**
     * Returns the rounded-off amount for the order.
     * @return The rounded-off amount.
     */
    public BigDecimal getRoundOff() {
        return roundOff;
    }

    /**
     * Sets the rounded-off amount for the order.
     * @param roundOff The rounded-off amount to set.
     */
    public void setRoundOff(BigDecimal roundOff) {
        this.roundOff = roundOff;
    }

    /**
     * Returns the total amount of the order.
     * @return The total amount.
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount of the order.
     * @param totalAmount The total amount to set.
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Returns the online tax calculated for the order.
     * @return The online tax calculated amount.
     */
    public BigDecimal getOnlineTaxCalculated() {
        return onlineTaxCalculated;
    }

    /**
     * Sets the online tax calculated for the order.
     * @param onlineTaxCalculated The online tax calculated amount to set.
     */
    public void setOnlineTaxCalculated(BigDecimal onlineTaxCalculated) {
        this.onlineTaxCalculated = onlineTaxCalculated;
    }

    /**
     * Returns the GST paid by e-commerce platforms.
     * @return The GST paid by e-commerce platforms amount.
     */
    public BigDecimal getGstPaidByEcommerce() {
        return gstPaidByEcommerce;
    }

    /**
     * Sets the GST paid by e-commerce platforms.
     * @param gstPaidByEcommerce The GST paid by e-commerce platforms amount to set.
     */
    public void setGstPaidByEcommerce(BigDecimal gstPaidByEcommerce) {
        this.gstPaidByEcommerce = gstPaidByEcommerce;
    }

    /**
     * Returns the amount of CGST.
     * @return The CGST amount.
     */
    public BigDecimal getAmountCgst() {
        return amountCgst;
    }

    /**
     * Sets the amount of CGST.
     * @param amountCgst The CGST amount to set.
     */
    public void setAmountCgst(BigDecimal amountCgst) {
        this.amountCgst = amountCgst;
    }

    /**
     * Returns the CGST rate.
     * @return The CGST rate.
     */
    public BigDecimal getCgst() {
        return cgst;
    }

    /**
     * Sets the CGST rate.
     * @param cgst The CGST rate to set.
     */
    public void setCgst(BigDecimal cgst) {
        this.cgst = cgst;
    }

    /**
     * Returns the amount of SGST.
     * @return The SGST amount.
     */
    public BigDecimal getAmountSgst() {
        return amountSgst;
    }

    /**
     * Sets the amount of SGST.
     * @param amountSgst The SGST amount to set.
     */
    public void setAmountSgst(BigDecimal amountSgst) {
        this.amountSgst = amountSgst;
    }

    /**
     * Returns the SGST rate.
     * @return The SGST rate.
     */
    public BigDecimal getSgst() {
        return sgst;
    }

    /**
     * Sets the SGST rate.
     * @param sgst The SGST rate to set.
     */
    public void setSgst(BigDecimal sgst) {
        this.sgst = sgst;
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
