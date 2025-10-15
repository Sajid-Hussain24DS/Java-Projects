package service;

import model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int bookId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();

    // Change int → String
    List<Book> getBooksByCategory(int categoryId);

    void goBack();
}
