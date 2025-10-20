package daoimpl;

import dao.BookDao;
 
import model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;
import model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private BookDaoImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    private DBConnection dbConnection;

    @Autowired
    private ApplicationContext context;


    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO lib_books (title, author, publisher, isbn, category_id, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getCategoryId(),
                book.getQuantity()
        );}


    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE lib_books SET title=?, author=?, publisher=?, isbn=?, category_id=?, quantity=? WHERE book_id=?";
        return jdbcTemplate.update(
                sql,
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getCategoryId(),
                book.getQuantity(),
                book.getBookId()
        );}

    @Override
    public int deleteBook(int bookId) {
        String sql = "DELETE FROM lib_books WHERE book_id=?";
         return jdbcTemplate.update(
                 sql,
                 bookId
         );
    }

    @Override
    public Book getBookById(int bookId) {
        String sql = "SELECT * FROM lib_books WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Book book =context.getBean(Book.class);
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPublisher(rs.getString("publisher"));
            book.setIsbn(rs.getString("isbn"));
            book.setCategoryId(rs.getInt("category_id"));
            book.setQuantity(rs.getInt("quantity"));
            return book;
        }, bookId);
    }


    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT b.book_id, b.title, b.author, b.publisher, b.isbn, b.quantity, " +
                "c.category_id, c.category_name " +
                "FROM lib_books b " +
                "INNER JOIN lib_categories c ON b.category_id = c.category_id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = context.getBean(Book.class);
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPublisher(rs.getString("publisher"));
            book.setIsbn(rs.getString("isbn"));
            book.setQuantity(rs.getInt("quantity"));
            book.setCategoryId(rs.getInt("category_id"));
            book.setCategoryName(rs.getString("category_name"));
            return book;});}

    @Override
    public List<Book> getBooksByCategory(int categoryId) {
        String sql = "SELECT * FROM lib_books WHERE category_id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPublisher(rs.getString("publisher"));
            book.setIsbn(rs.getString("isbn"));
            book.setCategoryId(rs.getInt("category_id"));
            book.setQuantity(rs.getInt("quantity"));
            return book;
        }, categoryId);}


    @Override
    public void decreaseBookQuantity(int bookId) {
        String sql = "UPDATE lib_books SET quantity = quantity - 1 WHERE book_id = ? AND quantity > 0";
        jdbcTemplate.update(sql, bookId);
    }


    @Override
    public boolean increaseBookQuantity(int bookId) {
        String sql = "UPDATE lib_books SET quantity = quantity + 1 WHERE book_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, bookId);
        return rowsAffected > 0;
    }
}
