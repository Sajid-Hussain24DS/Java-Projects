package daoImpl;

import Config.AppConfig;
import dao.BookDao;
 
import model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
                ApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
                    
                    public Book getBook(){
                        return context.getBean(Book.class);
                        }
    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO lib_books(title, author, publisher, isbn, category_id, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setString(4, book.getIsbn());
            ps.setInt(5, book.getCategoryId());
            ps.setInt(6, book.getQuantity());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE lib_books SET title=?, author=?, publisher=?, isbn=?, category_id=?, quantity=? WHERE book_id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setString(4, book.getIsbn());
            ps.setInt(5, book.getCategoryId());
            ps.setInt(6, book.getQuantity());
            ps.setInt(7, book.getBookId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int bookId) {
        String sql = "DELETE FROM lib_books WHERE book_id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, bookId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getBookById(int bookId) {
        String sql = "SELECT * FROM lib_books WHERE book_id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, bookId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
     
                    Book book = getBook();
                    book.setBookId(rs.getInt("book_id"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setCategoryId(rs.getInt("category_id"));
                    book.setQuantity(rs.getInt("quantity"));
                    return book;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

  @Override
public List<Book> getAllBooks() {
    List<Book> books = new ArrayList<>();
    String sql = "SELECT b.book_id, b.title, b.author, b.publisher, b.isbn, b.quantity, " +
                 "c.category_id, c.category_name " +
                 "FROM lib_books b " +
                 "INNER JOIN lib_categories c ON b.category_id = c.category_id";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Book book = getBook();
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPublisher(rs.getString("publisher"));
            book.setIsbn(rs.getString("isbn"));
            book.setQuantity(rs.getInt("quantity"));
            book.setCategoryId(rs.getInt("category_id"));
            book.setCategoryName(rs.getString("category_name")); // ✅ new field
            books.add(book);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return books;
}


    @Override
public List<Book> getBooksByCategory(int categoryId) {
    List<Book> books = new ArrayList<>();
    String sql = "SELECT * FROM lib_books WHERE category_id = ?";
    
    try (Connection connection = DBConnection.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, categoryId);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Book book = getBook();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getString("isbn"));
                book.setCategoryId(rs.getInt("category_id"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return books;
}

//public List<Book> getBooksByCategoryName(String categoryName) {
//    List<Book> books = new ArrayList<>();
//    String sql = "SELECT b.* FROM lib_books b " +
//                 "INNER JOIN lib_categories c ON b.category_id = c.category_id " +
//                 "WHERE c.category_name = ?";
//    
//    try (Connection connection = DBConnection.getConnection();
//         PreparedStatement ps = connection.prepareStatement(sql)) {
//
//        ps.setString(1, categoryName);
//        
//        try (ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                Book book = new Book();
//                book.setBookId(rs.getInt("book_id"));
//                book.setTitle(rs.getString("title"));
//                book.setAuthor(rs.getString("author"));
//                book.setPublisher(rs.getString("publisher"));
//                book.setIsbn(rs.getString("isbn"));
//                book.setCategoryId(rs.getInt("category_id"));
//                book.setQuantity(rs.getInt("quantity"));
//                books.add(book);
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return books;
//}
@Override
public void decreaseBookQuantity(int bookId) {
    String sql = "UPDATE lib_books SET quantity = quantity - 1 WHERE book_id = ? AND quantity > 0";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, bookId);
        stmt.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
        
    }
}

    @Override
    public boolean increaseBookQuantity(int bookId) {
         String sql = "UPDATE lib_books SET quantity = quantity + 1 WHERE book_id = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, bookId);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
}