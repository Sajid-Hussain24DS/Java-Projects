package service;

import  model.IssuedBook;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IssuedBookService {
    void issueBook(IssuedBook issuedBook);
    void returnBook(int issueId);
    void deleteIssuedRecord(int issueId);
    IssuedBook getIssuedBookById(int issueId);
    List<IssuedBook> getAllIssuedBooks();
    List<IssuedBook> getIssuedBooksByStudent(int studentId);
    void goBack();
}
