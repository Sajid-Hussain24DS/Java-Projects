CREATE DATABASE ecommerce_store;
USE ecommerce_store;

-- 1. Users
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    contact VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);

-- 2. Accounts
CREATE TABLE accounts (
    acc_id INT AUTO_INCREMENT PRIMARY KEY,
    bank VARCHAR(100),
    account_number VARCHAR(100),
    total_balance VARCHAR(100)

);

-- 3. Category
CREATE TABLE category (
    cat_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

-- 4. Vendor
CREATE TABLE vendor (
    vend_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    contact VARCHAR(100),
    address VARCHAR(255),
    account_num INT,
    FOREIGN KEY (account_num) REFERENCES accounts(acc_id)
);

-- 5. Products
CREATE TABLE products (
    p_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price INT,
    quantity INT,
    image VARCHAR(255),
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(cat_id)
);

-- 6. Purchase
CREATE TABLE purchase (
    purchase_id INT AUTO_INCREMENT PRIMARY KEY,
    purchase_no VARCHAR(100), -- e.g. P-{timestamp}
    total_amount INT,
    purchase_date DATE,
    vendor_id INT,
    FOREIGN KEY (vendor_id) REFERENCES vendor(vend_id)
);

-- 7. Purchase Details
CREATE TABLE purchase_details (
    pd_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    quantity INT,
    price INT,
    purchase_id INT,
    FOREIGN KEY (product_id) REFERENCES products(p_id),
    FOREIGN KEY (purchase_id) REFERENCES purchase(purchase_id)
);

-- 8. Cart
CREATE TABLE cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(p_id)
);

-- 9. Orders
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_phone VARCHAR(20),
    total_price INT,
    order_no VARCHAR(100), 
    date DATE
);

-- 10. Order Details
CREATE TABLE order_details (
    od_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    price INT,
    quantity INT,
    order_id INT,
    FOREIGN KEY (product_id) REFERENCES products(p_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);
DROP TABLE IF EXISTS payments;

CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NULL,
    purchase_id INT NULL,
    acc_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (purchase_id) REFERENCES purchase(purchase_id),
    FOREIGN KEY (acc_id) REFERENCES accounts(acc_id)
);
