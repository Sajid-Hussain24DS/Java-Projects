package serviceImpl;

import dao.IssuedBookDao;
import daoImpl.IssuedBookDaoImpl;
import model.IssuedBook;
import service.IssuedBookService;

import java.util.List;

public class IssuedBookServiceImpl implements IssuedBookService {

    private final IssuedBookDao issuedBookDAO = new IssuedBookDaoImpl();

    @Override
    public void issueBook(IssuedBook issuedBook) {
        issuedBookDAO.issueBook(issuedBook);
    }

    @Override
    public void returnBook(int issueId) {
        IssuedBook issuedBook = issuedBookDAO.getIssuedBookById(issueId);
        if (issuedBook != null) {
            // Use java.sql.Date for DAO compatibility
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
