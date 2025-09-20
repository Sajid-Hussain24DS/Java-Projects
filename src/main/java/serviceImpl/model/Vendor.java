 package model;

public class Vendor {
    private int vendId;
    private String name;
    private String contact;
    private String address;
    private int accountNum; // FK to Account

    public Vendor() {}

    public Vendor(int vendId, String name, String contact, String address, int accountNum) {
        this.vendId = vendId;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.accountNum = accountNum;
    }

    // Getters and Setters
    public int getVendId() { return vendId; }
    public void setVendId(int vendId) { this.vendId = vendId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getAccountNum() { return accountNum; }
    public void setAccountNum(int accountNum) { this.accountNum = accountNum; }

    @Override
    public String toString() {
        return "Vendor [vendId=" + vendId + ", name=" + name +
                ", contact=" + contact + ", address=" + address + "]";
    }
}
