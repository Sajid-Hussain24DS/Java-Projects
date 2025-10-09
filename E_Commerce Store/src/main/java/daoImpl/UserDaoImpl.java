package daoImpl;

import dao.UserDao;
import model.User;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection conn;

    public UserDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO users(name, contact, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getContact());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        int rows = ps.executeUpdate();
        
        return rows >0;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new User(
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("contact"),
                rs.getString("email"),
                rs.getString("password")
            );
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new User(
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("contact"),
                rs.getString("email"),
                rs.getString("password")
            ));
        }
        return list;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
    String sql = "UPDATE users SET name=?, contact=?, email=?, password=? WHERE user_id=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, user.getName());
    ps.setString(2, user.getContact());
    ps.setString(3, user.getEmail());
    ps.setString(4, user.getPassword());
    ps.setInt(5, user.getUserId());
    int rows = ps.executeUpdate();
    return rows > 0;
}


    @Override
    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
       int rows =  ps.executeUpdate();
       return rows>0;
    }

    @Override
public User getUserByEmail(String email) throws SQLException {
    String sql = "SELECT * FROM users WHERE email=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, email);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        return new User(
            rs.getInt("user_id"),
            rs.getString("name"),
            rs.getString("contact"),
            rs.getString("email"),
            rs.getString("password")
        );
    }
    return null;  
}

}
