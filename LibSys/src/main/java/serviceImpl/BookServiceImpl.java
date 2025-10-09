package serviceImpl;

import dao.BookDao;
import daoImpl.BookDaoImpl;
 
import model.Book;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

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
