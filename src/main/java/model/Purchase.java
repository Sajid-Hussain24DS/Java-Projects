package model;

import java.sql.Date;

public class Purchase {
    private int purchaseId;
    private String purchaseNo;
    private int totalAmount;
    private Date purchaseDate;
    private int vendorId;

    public Purchase() {}

    public Purchase(int purchaseId, String purchaseNo, int totalAmount, Date purchaseDate, int vendorId) {
        this.purchaseId = purchaseId;
        this.purchaseNo = purchaseNo;
        this.totalAmount = totalAmount;
        this.purchaseDate = purchaseDate;
        this.vendorId = vendorId;
    }

    // Getters and Setters
    public int getPurchaseId() { return purchaseId; }
    public void setPurchaseId(int purchaseId) { this.purchaseId = purchaseId; }

    public String getPurchaseNo() { return purchaseNo; }
    public void setPurchaseNo(String purchaseNo) { this.purchaseNo = purchaseNo; }

    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }

    public int getVendorId() { return vendorId; }
    public void setVendorId(int vendorId) { this.vendorId = vendorId; }

    @Override
    public String toString() {
        return "Purchase [purchaseId=" + purchaseId + ", purchaseNo=" + purchaseNo +
                ", totalAmount=" + totalAmount + ", purchaseDate=" + purchaseDate +
                ", vendorId=" + vendorId + "]";
    }
}
