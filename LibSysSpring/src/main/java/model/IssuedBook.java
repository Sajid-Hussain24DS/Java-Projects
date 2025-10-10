package model;

import java.sql.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class IssuedBook {
    private int issueId;
    private int studentId;
    private int bookId;
    private java.util.Date issueDate;
    private java.util.Date dueDate;
    private java.util.Date returnDate;
    
    public IssuedBook(){}
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