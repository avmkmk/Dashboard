
CREATE SCHEMA IF NOT EXISTS analytics_schema;

CREATE TABLE IF NOT EXISTS analytics_schema.daily_kpis (
    id BIGSERIAL PRIMARY KEY,
    report_date DATE UNIQUE,
    total_revenue NUMERIC(10, 2),
    aggregator_revenue_zomato NUMERIC(10, 2),
    aggregator_revenue_swiggy NUMERIC(10, 2),
    aggregator_revenue_pickup NUMERIC(10, 2),
    estimated_aggregator_commission NUMERIC(10, 2),
    total_food_cost NUMERIC(10, 2),
    estimated_wastage_amount NUMERIC(10, 2),
    total_order_count INTEGER,
    new_customer_count INTEGER,
    repeat_customer_count INTEGER,
    last_updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS analytics_schema.weekly_kpis (
    id BIGSERIAL PRIMARY KEY,
    week_start_date DATE UNIQUE,
    total_revenue NUMERIC(10, 2)
    -- ... other aggregated metrics
);

CREATE TABLE IF NOT EXISTS analytics_schema.monthly_kpis (
    id BIGSERIAL PRIMARY KEY,
    month_start_date DATE UNIQUE,
    total_revenue NUMERIC(10, 2)
    -- ... other aggregated metrics
);
