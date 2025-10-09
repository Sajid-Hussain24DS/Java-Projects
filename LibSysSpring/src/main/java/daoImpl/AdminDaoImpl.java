package daoImpl;

import dao.AdminDao;
import model.Admin;
import database.DBConnection;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class AdminDaoImpl implements AdminDao {

    private Connection conn;

    public AdminDaoImpl() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Admin login(String username, String password) {
        String sql = "SELECT * FROM lib_admins WHERE username=? AND password=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(
                        rs.getInt("admin_id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // login failed
    }

    @Override
    public void back() {
        System.out.println("⬅ Going back to previous menu...");
    }
}
