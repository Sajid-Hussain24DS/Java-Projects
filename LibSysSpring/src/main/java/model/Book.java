package model;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int categoryId; // Store category ID as int
    private int quantity;
    private String categoryName;
    
    public Book(int bookId, String title, String author, String publisher, String isbn, int categoryId, String categoryName, int quantity) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.isbn = isbn;
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.quantity = quantity;
}

    // Default Constructor
    public Book() {}

    // Getters and Setters
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title != null ? title.trim() : null; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author != null ? author.trim() : null; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher != null ? publisher.trim() : null; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn != null ? isbn.trim() : null; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }


    public int getId() {
        return this.bookId;
    }
    
public String getCategoryName() { return categoryName; }
public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author +
                ", publisher=" + publisher + ", isbn=" + isbn +
                ", categoryId=" + categoryId + ", quantity=" + quantity + "]";
    }
 
}
