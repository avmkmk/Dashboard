
CREATE SCHEMA IF NOT EXISTS raw_data_schema;

CREATE TABLE IF NOT EXISTS raw_data_schema.raw_items_data (
    id BIGSERIAL PRIMARY KEY,
    date DATE,
    timestamp TIMESTAMP,
    invoice_no VARCHAR(50),
    item_name VARCHAR(255),
    qty INTEGER,
    tax NUMERIC(10, 2),
    variation VARCHAR(255) NULL,
    category VARCHAR(255) NULL,
    raw_line TEXT
);

CREATE TABLE IF NOT EXISTS raw_data_schema.raw_orders_data (
    id BIGSERIAL PRIMARY KEY,
    invoice_no VARCHAR(50),
    date DATE,
    timestamp TIMESTAMP,
    payment_type VARCHAR(100),
    order_type VARCHAR(100),
    area VARCHAR(100) NULL,
    sub_order_type VARCHAR(100) NULL,
    phone VARCHAR(20) NULL,
    name VARCHAR(255) NULL,
    address TEXT NULL,
    my_amount NUMERIC(10, 2),
    discount NUMERIC(10, 2),
    net_sales NUMERIC(10, 2),
    container_charge NUMERIC(10, 2),
    total_tax NUMERIC(10, 2),
    round_off NUMERIC(10, 2),
    total_amount NUMERIC(10, 2),
    online_tax_calculated NUMERIC(10, 2) NULL,
    gst_paid_by_ecommerce NUMERIC(10, 2) NULL,
    amount_cgst NUMERIC(10, 2) NULL,
    cgst NUMERIC(10, 2) NULL,
    amount_sgst NUMERIC(10, 2) NULL,
    sgst NUMERIC(10, 2) NULL,
    raw_line TEXT
);
