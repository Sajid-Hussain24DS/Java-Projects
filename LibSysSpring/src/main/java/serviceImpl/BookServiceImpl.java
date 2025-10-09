package serviceImpl;

import dao.BookDao;
import daoImpl.BookDaoImpl;
 
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.BookService;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookDao.deleteBook(bookId);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    

    @Override
    public void goBack() {
        System.out.println("Back to Dashboard from Books...");
    }

    // Remove the String version completely if you are using category IDs

    @Override
    public List<Book> getBooksByCategory(int categoryId) {
         return bookDao.getBooksByCategory(categoryId);
}
}
