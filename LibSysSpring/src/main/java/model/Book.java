package model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "lib_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title") private String title;

    @Column(name = "author") private String author;

    @Column(name = "publisher") private String publisher;

    @Column(name = "isbn") private String isbn;

    @Column(name = "category_id") private int categoryId; // Store category ID as int

    @Column(name = "quantity") private int quantity;

    @Column(name = "categoryName") private String categoryName;
    
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
