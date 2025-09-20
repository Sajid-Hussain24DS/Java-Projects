package daoimpl;

import dao.IssuedBookDao;
import model.IssuedBook;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssuedBookDaoImpl implements IssuedBookDao {

    private Connection conn;

    public IssuedBookDaoImpl() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasActiveIssue(int studentId, int bookId) {
        String sql = "SELECT COUNT(*) FROM lib_issued_books WHERE student_id = ? AND book_id = ? AND return_date IS NULL";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, bookId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean issuedBook(int studentId, int bookId, Date issueDate, Date dueDate) {
        String sql = "INSERT INTO lib_issued_books (student_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, bookId);
            stmt.setDate(3, issueDate);
            stmt.setDate(4, dueDate);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean issueBook(IssuedBook issuedBook) {
        String sql = "INSERT INTO lib_issued_books (student_id, book_id, issue_date, due_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, issuedBook.getStudentId());
            stmt.setInt(2, issuedBook.getBookId());
            stmt.setDate(3, new java.sql.Date(issuedBook.getIssueDate().getTime()));
            stmt.setDate(4, new java.sql.Date(issuedBook.getDueDate().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public IssuedBook getIssuedBookById(int issueId) {
        String sql = "SELECT * FROM lib_issued_books WHERE issue_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, issueId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                IssuedBook issuedBook = new IssuedBook();
                issuedBook.setIssueId(rs.getInt("issue_id"));
                issuedBook.setStudentId(rs.getInt("student_id"));
                issuedBook.setBookId(rs.getInt("book_id"));
                issuedBook.setIssueDate(rs.getDate("issue_date"));
                issuedBook.setDueDate(rs.getDate("due_date"));
                issuedBook.setReturnDate(rs.getDate("return_date"));
                return issuedBook;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean deleteIssuedRecord(int issueId) {
        String sql = "DELETE FROM lib_issued_books WHERE issue_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, issueId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<IssuedBook> getAllIssuedBooks() {
        List<IssuedBook> issuedBooks = new ArrayList<>();
        String sql = "SELECT * FROM lib_issued_books";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                IssuedBook issuedBook = new IssuedBook();
                issuedBook.setIssueId(rs.getInt("issue_id"));
                issuedBook.setStudentId(rs.getInt("student_id"));
                issuedBook.setBookId(rs.getInt("book_id"));
                issuedBook.setIssueDate(rs.getDate("issue_date"));
                issuedBook.setDueDate(rs.getDate("due_date"));
                issuedBook.setReturnDate(rs.getDate("return_date"));
                issuedBooks.add(issuedBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issuedBooks;
    }
    
    @Override
    public List<IssuedBook> getIssuedBooksByStudent(int studentId) {
        List<IssuedBook> issuedBooks = new ArrayList<>();
        String sql = "SELECT * FROM lib_issued_books WHERE student_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                IssuedBook issuedBook = new IssuedBook();
                issuedBook.setIssueId(rs.getInt("issue_id"));
                issuedBook.setStudentId(rs.getInt("student_id"));
                issuedBook.setBookId(rs.getInt("book_id"));
                issuedBook.setIssueDate(rs.getDate("issue_date"));
                issuedBook.setDueDate(rs.getDate("due_date"));
                issuedBook.setReturnDate(rs.getDate("return_date"));
                issuedBooks.add(issuedBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issuedBooks;
    }
    
    // Don't forget to close the connection when done
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
public void addIssue(IssuedBook issuedBook) {
    String sql = "INSERT INTO lib_issued_books (student_id, book_id, issue_date, due_date, return_date) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, issuedBook.getStudentId());
        stmt.setInt(2, issuedBook.getBookId());
        stmt.setDate(3, new java.sql.Date(issuedBook.getIssueDate().getTime()));
        stmt.setDate(4, new java.sql.Date(issuedBook.getDueDate().getTime()));
        
        if (issuedBook.getReturnDate() != null) {
            stmt.setDate(5, new java.sql.Date(issuedBook.getReturnDate().getTime()));
        } else {
            stmt.setNull(5, java.sql.Types.DATE);
        }
        
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error adding issue record", e);
    }
}

@Override
public void updateIssue(IssuedBook issuedBook) {
    String sql = "UPDATE lib_issued_books SET student_id = ?, book_id = ?, issue_date = ?, due_date = ?, return_date = ? WHERE issue_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, issuedBook.getStudentId());
        stmt.setInt(2, issuedBook.getBookId());
        stmt.setDate(3, new java.sql.Date(issuedBook.getIssueDate().getTime()));
        stmt.setDate(4, new java.sql.Date(issuedBook.getDueDate().getTime()));
        
        if (issuedBook.getReturnDate() != null) {
            stmt.setDate(5, new java.sql.Date(issuedBook.getReturnDate().getTime()));
        } else {
            stmt.setNull(5, java.sql.Types.DATE);
        }
        
        stmt.setInt(6, issuedBook.getIssueId());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error updating issue record", e);
    }
}

@Override
public void deleteIssue(int issueId) {
    String sql = "DELETE FROM lib_issued_books WHERE issue_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, issueId);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error deleting issue record", e);
    }
}

@Override
public IssuedBook getIssueById(int issueId) {
    String sql = "SELECT * FROM lib_issued_books WHERE issue_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, issueId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return mapResultSetToIssuedBook(rs);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error retrieving issue by ID", e);
    }
    return null;
}

@Override
public List<IssuedBook> getAllIssues() {
    List<IssuedBook> issues = new ArrayList<>();
    String sql = "SELECT * FROM lib_issued_books ORDER BY issue_date DESC";
    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            issues.add(mapResultSetToIssuedBook(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error retrieving all issues", e);
    }
    return issues;
}

@Override
public List<IssuedBook> getIssuesByMemberId(int memberId) {
    List<IssuedBook> issues = new ArrayList<>();
    String sql = "SELECT * FROM lib_issued_books WHERE student_id = ? ORDER BY issue_date DESC";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, memberId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            issues.add(mapResultSetToIssuedBook(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error retrieving issues by member ID", e);
    }
    return issues;
}

@Override
public List<IssuedBook> getIssuesByBookId(int bookId) {
    List<IssuedBook> issues = new ArrayList<>();
    String sql = "SELECT * FROM lib_issued_books WHERE book_id = ? ORDER BY issue_date DESC";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, bookId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            issues.add(mapResultSetToIssuedBook(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error retrieving issues by book ID", e);
    }
    return issues;
}

// Helper method to map ResultSet to IssuedBook object
private IssuedBook mapResultSetToIssuedBook(ResultSet rs) throws SQLException {
    IssuedBook issuedBook = new IssuedBook();
    issuedBook.setIssueId(rs.getInt("issue_id"));
    issuedBook.setStudentId(rs.getInt("student_id"));
    issuedBook.setBookId(rs.getInt("book_id"));
    issuedBook.setIssueDate(rs.getDate("issue_date"));
    issuedBook.setDueDate(rs.getDate("due_date"));
    issuedBook.setReturnDate(rs.getDate("return_date"));
    return issuedBook;
}

   @Override
public boolean returnBook(int studentId, int bookId, Date returnDate) {
    String sql = "UPDATE lib_issued_books SET return_date = ? WHERE student_id = ? AND book_id = ? AND return_date IS NULL";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setDate(1, returnDate);
        stmt.setInt(2, studentId);
        stmt.setInt(3, bookId);
        
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
//@Override
//public boolean hasActiveIssue(int studentId, int bookId) {
//    String sql = "SELECT COUNT(*) FROM issued_books WHERE student_id = ? AND book_id = ? AND return_date IS NULL";
//    
//    try (Connection conn = DBConnection.getConnection();
//         PreparedStatement stmt = conn.prepareStatement(sql)) {
//        
//        stmt.setInt(1, studentId);
//        stmt.setInt(2, bookId);
//        
//        ResultSet rs = stmt.executeQuery();
//        if (rs.next()) {
//            return rs.getInt(1) > 0;
//        }
//        return false;
//        
//    } catch (SQLException e) {
//        e.printStackTrace();
//        return false;
//    }
//}

    @Override
public boolean deleteIssuedBook(int issueId) {
    String sql = "DELETE FROM lib_issued_books WHERE issue_id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, issueId);
        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}