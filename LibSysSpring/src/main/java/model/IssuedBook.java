package model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
@Component
@Entity
@Table(name = "lib_issued_books")
public class IssuedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private int issueId;
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "issue_date")
    private java.util.Date issueDate;
    @Column(name = "due_date")
    private java.util.Date dueDate;
    @Column(name = "return_date")
    private java.util.Date returnDate;
    
    // Getters and setters for all fields
    public int getIssueId() { return issueId; }
    public void setIssueId(int issueId) { this.issueId = issueId; }
    
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    
    public java.util.Date getIssueDate() { return issueDate; }
    public void setIssueDate(java.util.Date issueDate) { this.issueDate = issueDate; }
    
    public java.util.Date getDueDate() { return dueDate; }
    public void setDueDate(java.util.Date dueDate) { this.dueDate = dueDate; }
    
    public java.util.Date getReturnDate() { return returnDate; }
    public void setReturnDate(java.util.Date returnDate) { this.returnDate = returnDate; }
}