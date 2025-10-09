package model;

public class Product {
    private int pId;
    private String name;
    private int price;
    private int quantity;
    private String image;
    private int categoryId; // FK

    public Product() {}

    public Product(int pId, String name, int price, int quantity, String image, int categoryId) {
        this.pId = pId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.categoryId = categoryId;
    }

    // Getters and Setters
    public int getPId() { return pId; }
    public void setPId(int pId) { this.pId = pId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    @Override
    public String toString() {
        return "Product [pId=" + pId + ", name=" + name + ", price=" + price +
                ", quantity=" + quantity + ", categoryId=" + categoryId + "]";
    }
}
