package model;

public class PurchaseDetail {
    private int pdId;
    private int productId;
    private int quantity;
    private int price;
    private int purchaseId;

    public PurchaseDetail() {}

    public PurchaseDetail(int pdId, int productId, int quantity, int price, int purchaseId) {
        this.pdId = pdId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.purchaseId = purchaseId;
    }

    // Getters and Setters
    public int getPdId() { return pdId; }
    public void setPdId(int pdId) { this.pdId = pdId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getPurchaseId() { return purchaseId; }
    public void setPurchaseId(int purchaseId) { this.purchaseId = purchaseId; }

    @Override
    public String toString() {
        return "PurchaseDetail [pdId=" + pdId + ", productId=" + productId +
                ", quantity=" + quantity + ", price=" + price + ", purchaseId=" + purchaseId + "]";
    }
}
