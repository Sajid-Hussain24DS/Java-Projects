package dao;

import java.sql.Date;
import java.util.List;
import model.IssuedBook;
import org.springframework.stereotype.Component;

@Component
public interface IssuedBookDao {
    void addIssue(IssuedBook issuedBook);
    void updateIssue(IssuedBook issuedBook);
    void deleteIssue(int issueId);   
    IssuedBook getIssueById(int issueId);
    List<IssuedBook> getAllIssues();
    List<IssuedBook> getIssuesByMemberId(int memberId);
    List<IssuedBook> getIssuesByBookId(int bookId);
    
    
    boolean hasActiveIssue(int studentId, int bookId);
    boolean issuedBook(int studentId, int bookId, Date issueDate, Date dueDate);
    boolean issueBook(IssuedBook issuedBook);
    IssuedBook getIssuedBookById(int issueId);
    boolean deleteIssuedRecord(int issueId);
    List<IssuedBook> getAllIssuedBooks();
    List<IssuedBook> getIssuedBooksByStudent(int studentId);

    public boolean returnBook(int studentId, int bookId, Date returnDate);

    public boolean deleteIssuedBook(int sueId);
}
