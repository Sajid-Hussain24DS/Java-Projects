package dao;

import model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BookDao {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int bookId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();
    

    public List<Book> getBooksByCategory(int categoryId);

    public void decreaseBookQuantity(int bookId);

    public boolean increaseBookQuantity(int bookId);
}