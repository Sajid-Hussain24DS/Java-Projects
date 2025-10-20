package daoimpl;

import dao.IssuedBookDao;
import model.IssuedBook;
import database.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class IssuedBookDaoImpl implements IssuedBookDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private IssuedBookDaoImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;}


            @Override
            public boolean hasActiveIssue(int studentId, int bookId) {
                String sql = "SELECT COUNT(*) FROM lib_issued_books WHERE student_id = ? AND book_id = ? AND return_date IS NULL";
                Integer count = jdbcTemplate.queryForObject(sql, Integer.class, studentId, bookId);
                return count != null && count > 0;
            }

            @Override
            public boolean issuedBook(int studentId, int bookId, Date issueDate, Date dueDate) {
                String sql = "INSERT INTO lib_issued_books (student_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?)";
                return jdbcTemplate.update(sql, studentId, bookId, issueDate, dueDate) > 0;
            }

            @Override
            public boolean issueBook(IssuedBook issuedBook) {
                String sql = "INSERT INTO lib_issued_books (student_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?)";
                return jdbcTemplate.update(
                        sql,
                        issuedBook.getStudentId(),
                        issuedBook.getBookId(),
                        issuedBook.getIssueDate(),
                        issuedBook.getDueDate()
                ) > 0;
            }

            @Override
            public IssuedBook getIssuedBookById(int issueId) {
                String sql = "SELECT * FROM lib_issued_books WHERE issue_id = ?";
                return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                    IssuedBook book = new IssuedBook();
                    book.setIssueId(rs.getInt("issue_id"));
                    book.setStudentId(rs.getInt("student_id"));
                    book.setBookId(rs.getInt("book_id"));
                    book.setIssueDate(rs.getDate("issue_date"));
                    book.setDueDate(rs.getDate("due_date"));
                    book.setReturnDate(rs.getDate("return_date"));
                    return book;
                }, issueId);
            }

            @Override
            public boolean deleteIssuedRecord(int issueId) {
                String sql = "DELETE FROM lib_issued_books WHERE issue_id = ?";
                return jdbcTemplate.update(sql, issueId) > 0;
            }

            @Override
            public List<IssuedBook> getAllIssuedBooks() {
                String sql = "SELECT * FROM lib_issued_books";
                return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    IssuedBook issuedBook = new IssuedBook();
                    issuedBook.setIssueId(rs.getInt("issue_id"));
                    issuedBook.setStudentId(rs.getInt("student_id"));
                    issuedBook.setBookId(rs.getInt("book_id"));
                    issuedBook.setIssueDate(rs.getDate("issue_date"));
                    issuedBook.setDueDate(rs.getDate("due_date"));
                    issuedBook.setReturnDate(rs.getDate("return_date"));
                    return issuedBook;
                });
            }

            @Override
            public List<IssuedBook> getIssuedBooksByStudent(int studentId) {
                String sql = "SELECT * FROM lib_issued_books WHERE student_id = ?";
                return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    IssuedBook issuedBook = new IssuedBook();
                    issuedBook.setIssueId(rs.getInt("issue_id"));
                    issuedBook.setStudentId(rs.getInt("student_id"));
                    issuedBook.setBookId(rs.getInt("book_id"));
                    issuedBook.setIssueDate(rs.getDate("issue_date"));
                    issuedBook.setDueDate(rs.getDate("due_date"));
                    issuedBook.setReturnDate(rs.getDate("return_date"));
                    return issuedBook;
                }, studentId);
            }

            @Override
            public void addIssue(IssuedBook issuedBook) {
                String sql = "INSERT INTO lib_issued_books (student_id, book_id, issue_date, due_date, return_date) VALUES (?, ?, ?, ?, ?)";
                jdbcTemplate.update(
                        sql,
                        issuedBook.getStudentId(),
                        issuedBook.getBookId(),
                        issuedBook.getIssueDate(),
                        issuedBook.getDueDate(),
                        issuedBook.getReturnDate()
                );
            }

            @Override
            public void updateIssue(IssuedBook issuedBook) {
                String sql = "UPDATE lib_issued_books SET student_id = ?, book_id = ?, issue_date = ?, due_date = ?, return_date = ? WHERE issue_id = ?";
                jdbcTemplate.update(
                        sql,
                        issuedBook.getStudentId(),
                        issuedBook.getBookId(),
                        issuedBook.getIssueDate(),
                        issuedBook.getDueDate(),
                        issuedBook.getReturnDate(),
                        issuedBook.getIssueId()
                );
            }

            @Override
            public void deleteIssue(int issueId) {
                String sql = "DELETE FROM lib_issued_books WHERE issue_id = ?";
                jdbcTemplate.update(sql, issueId);
            }

            @Override
            public IssuedBook getIssueById(int issueId) {
                String sql = "SELECT * FROM lib_issued_books WHERE issue_id = ?";
                return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                    IssuedBook issue = new IssuedBook();
                    issue.setIssueId(rs.getInt("issue_id"));
                    issue.setStudentId(rs.getInt("student_id"));
                    issue.setBookId(rs.getInt("book_id"));
                    issue.setIssueDate(rs.getDate("issue_date"));
                    issue.setDueDate(rs.getDate("due_date"));
                    issue.setReturnDate(rs.getDate("return_date"));
                    return issue;
                }, issueId);
            }

            @Override
            public List<IssuedBook> getAllIssues() {
                String sql = "SELECT * FROM lib_issued_books ORDER BY issue_date DESC";
                return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    IssuedBook issue = new IssuedBook();
                    issue.setIssueId(rs.getInt("issue_id"));
                    issue.setStudentId(rs.getInt("student_id"));
                    issue.setBookId(rs.getInt("book_id"));
                    issue.setIssueDate(rs.getDate("issue_date"));
                    issue.setDueDate(rs.getDate("due_date"));
                    issue.setReturnDate(rs.getDate("return_date"));
                    return issue;
                });
            }

            @Override
            public List<IssuedBook> getIssuesByMemberId(int memberId) {
                String sql = "SELECT * FROM lib_issued_books WHERE student_id = ? ORDER BY issue_date DESC";
                return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    IssuedBook issue = new IssuedBook();
                    issue.setIssueId(rs.getInt("issue_id"));
                    issue.setStudentId(rs.getInt("student_id"));
                    issue.setBookId(rs.getInt("book_id"));
                    issue.setIssueDate(rs.getDate("issue_date"));
                    issue.setDueDate(rs.getDate("due_date"));
                    issue.setReturnDate(rs.getDate("return_date"));
                    return issue;
                }, memberId);
            }

            @Override
            public List<IssuedBook> getIssuesByBookId(int bookId) {
                String sql = "SELECT * FROM lib_issued_books WHERE book_id = ? ORDER BY issue_date DESC";
                return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    IssuedBook issue = new IssuedBook();
                    issue.setIssueId(rs.getInt("issue_id"));
                    issue.setStudentId(rs.getInt("student_id"));
                    issue.setBookId(rs.getInt("book_id"));
                    issue.setIssueDate(rs.getDate("issue_date"));
                    issue.setDueDate(rs.getDate("due_date"));
                    issue.setReturnDate(rs.getDate("return_date"));
                    return issue;
                }, bookId);
            }

            @Override
            public boolean returnBook(int studentId, int bookId, Date returnDate) {
                String sql = "UPDATE lib_issued_books SET return_date = ? WHERE student_id = ? AND book_id = ? AND return_date IS NULL";
                int rows = jdbcTemplate.update(sql, returnDate, studentId, bookId);
                return rows > 0;
            }

            @Override
            public boolean deleteIssuedBook(int issueId) {
                String sql = "DELETE FROM lib_issued_books WHERE issue_id = ?";
                int rows = jdbcTemplate.update(sql, issueId);
                return rows > 0;
            }
        }


