package model;

public class OrderDetail {
    private int odId;
    private int productId;
    private int price;
    private int quantity;
    private int orderId;

    public OrderDetail() {}

    public OrderDetail(int odId, int productId, int price, int quantity, int orderId) {
        this.odId = odId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    // Getters and Setters
    public int getOdId() { return odId; }
    public void setOdId(int odId) { this.odId = odId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    @Override
    public String toString() {
        return "OrderDetail [odId=" + odId + ", productId=" + productId +
                ", price=" + price + ", quantity=" + quantity + ", orderId=" + orderId + "]";
    }
}
