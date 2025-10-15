package serviceImpl;

import dao.IssuedBookDao;
import daoimpl.IssuedBookDaoImpl;
import model.IssuedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.IssuedBookService;

import java.util.List;
@Service
public class IssuedBookServiceImpl implements IssuedBookService {

    @Autowired
    private IssuedBookDao issuedBookDAO ;

    @Override
    public void issueBook(IssuedBook issuedBook) {
        issuedBookDAO.issueBook(issuedBook);
    }

    @Override
    public void returnBook(int issueId) {
        IssuedBook issuedBook = issuedBookDAO.getIssuedBookById(issueId);
        if (issuedBook != null) {

            issuedBook.setReturnDate(new java.sql.Date(System.currentTimeMillis()));
            issuedBookDAO.issueBook(issuedBook); // or implement updateIssue() in DAO
            System.out.println("✅ Book returned successfully.");
        } else {
            System.out.println("❌ Issue record not found!");
        }
    }

    @Override
    public void deleteIssuedRecord(int issueId) {
        issuedBookDAO.deleteIssuedRecord(issueId);
    }

    @Override
    public IssuedBook getIssuedBookById(int issueId) {
        return issuedBookDAO.getIssuedBookById(issueId);
    }

    @Override
    public List<IssuedBook> getAllIssuedBooks() {
        return issuedBookDAO.getAllIssuedBooks();
    }

    @Override
    public List<IssuedBook> getIssuedBooksByStudent(int studentId) {
        return issuedBookDAO.getIssuedBooksByStudent(studentId);
    }

    @Override
    public void goBack() {
        System.out.println("⬅ Back to Dashboard from Issued Books...");
    }
}
