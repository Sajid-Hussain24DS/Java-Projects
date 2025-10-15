package daoimpl;

import dao.AdminDao;
import model.Admin;
import database.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdminDaoImpl implements AdminDao {


    @Autowired
    private DBConnection dbConnection;
    @Override
    public Admin login(String username, String password) {
        try(Connection conn = dbConnection.getConnection()){
        String sql = "SELECT * FROM lib_admins WHERE username=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
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
