package model;

import java.sql.Date;

public class Order {
    private int orderId;
    private String customerPhone;
    private int totalPrice;
    private String orderNo;
    private Date date;

    public Order() {}

    public Order(int orderId, String customerPhone, int totalPrice, String orderNo, Date date) {
        this.orderId = orderId;
        this.customerPhone = customerPhone;
        this.totalPrice = totalPrice;
        this.orderNo = orderNo;
        this.date = date;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }

    public int getTotalPrice() { return totalPrice; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }

    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerPhone=" + customerPhone +
                ", totalPrice=" + totalPrice + ", orderNo=" + orderNo + ", date=" + date + "]";
    }
}
