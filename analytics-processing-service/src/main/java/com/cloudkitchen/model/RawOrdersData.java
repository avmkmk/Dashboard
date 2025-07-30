package com.cloudkitchen.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "raw_orders_data", schema = "raw_data_schema")
public class RawOrdersData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_no")
    private String invoiceNo;

    private Timestamp date;
    private Timestamp timestamp;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "order_type")
    private String orderType;

    private String area;

    @Column(name = "sub_order_type")
    private String subOrderType;

    private String phone;
    private String name;
    private String address;

    @Column(name = "my_amount")
    private BigDecimal myAmount;

    private BigDecimal discount;

    @Column(name = "net_sales")
    private BigDecimal netSales;

    @Column(name = "container_charge")
    private BigDecimal containerCharge;

    @Column(name = "total_tax")
    private BigDecimal totalTax;

    @Column(name = "round_off")
    private BigDecimal roundOff;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "online_tax_calculated")
    private BigDecimal onlineTaxCalculated;

    @Column(name = "gst_paid_by_ecommerce")
    private BigDecimal gstPaidByEcommerce;

    @Column(name = "amount_cgst")
    private BigDecimal amountCgst;

    private BigDecimal cgst;

    @Column(name = "amount_sgst")
    private BigDecimal amountSgst;

    private BigDecimal sgst;

    @Column(name = "raw_line", columnDefinition = "TEXT")
    private String rawLine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubOrderType() {
        return subOrderType;
    }

    public void setSubOrderType(String subOrderType) {
        this.subOrderType = subOrderType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getMyAmount() {
        return myAmount;
    }

    public void setMyAmount(BigDecimal myAmount) {
        this.myAmount = myAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getNetSales() {
        return netSales;
    }

    public void setNetSales(BigDecimal netSales) {
        this.netSales = netSales;
    }

    public BigDecimal getContainerCharge() {
        return containerCharge;
    }

    public void setContainerCharge(BigDecimal containerCharge) {
        this.containerCharge = containerCharge;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getRoundOff() {
        return roundOff;
    }

    public void setRoundOff(BigDecimal roundOff) {
        this.roundOff = roundOff;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getOnlineTaxCalculated() {
        return onlineTaxCalculated;
    }

    public void setOnlineTaxCalculated(BigDecimal onlineTaxCalculated) {
        this.onlineTaxCalculated = onlineTaxCalculated;
    }

    public BigDecimal getGstPaidByEcommerce() {
        return gstPaidByEcommerce;
    }

    public void setGstPaidByEcommerce(BigDecimal gstPaidByEcommerce) {
        this.gstPaidByEcommerce = gstPaidByEcommerce;
    }

    public BigDecimal getAmountCgst() {
        return amountCgst;
    }

    public void setAmountCgst(BigDecimal amountCgst) {
        this.amountCgst = amountCgst;
    }

    public BigDecimal getCgst() {
        return cgst;
    }

    public void setCgst(BigDecimal cgst) {
        this.cgst = cgst;
    }

    public BigDecimal getAmountSgst() {
        return amountSgst;
    }

    public void setAmountSgst(BigDecimal amountSgst) {
        this.amountSgst = amountSgst;
    }

    public BigDecimal getSgst() {
        return sgst;
    }

    public void setSgst(BigDecimal sgst) {
        this.sgst = sgst;
    }

    public String getRawLine() {
        return rawLine;
    }

    public void setRawLine(String rawLine) {
        this.rawLine = rawLine;
    }
}
