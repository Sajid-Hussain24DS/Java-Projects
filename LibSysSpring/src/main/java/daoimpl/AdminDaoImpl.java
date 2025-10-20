package daoimpl;

import dao.AdminDao;
import model.Admin;
import database.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdminDaoImpl implements AdminDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🔐 Login Method
    @Override
    public Admin login(String username, String password) {
        String sql = "SELECT * FROM lib_admins WHERE username = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, (rs, rowNum) ->
                    new Admin(
                            rs.getInt("admin_id"),
                            rs.getString("username"),
                            rs.getString("password")
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return null; // login failed
        }
    }

    // ⬅ Back Method
    @Override
    public void back() {
        System.out.println("⬅ Going back to previous menu...");
    }
}
