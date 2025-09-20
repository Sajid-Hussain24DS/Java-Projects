package daoImpl;

import dao.CartDao;
import model.Cart;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private Connection conn;

    public CartDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void addCart(Cart cart) throws SQLException {
        String sql = "INSERT INTO cart(user_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cart.getUserId());
        ps.setInt(2, cart.getProductId());
        ps.setInt(3, cart.getQuantity());
        ps.executeUpdate();
    }

    @Override
    public Cart getCartById(int id) throws SQLException {
        String sql = "SELECT * FROM cart WHERE cart_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Cart(
                rs.getInt("cart_id"),
                rs.getInt("user_id"),
                rs.getInt("product_id"),
                rs.getInt("quantity")
            );
        }
        return null;
    }

    @Override
    public List<Cart> getAllCarts() throws SQLException {
        List<Cart> list = new ArrayList<>();
        String sql = "SELECT * FROM cart";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new Cart(
                rs.getInt("cart_id"),
                rs.getInt("user_id"),
                rs.getInt("product_id"),
                rs.getInt("quantity")
            ));
        }
        return list;
    }

    @Override
    public boolean updateCart(Cart cart) throws SQLException {
        String sql = "UPDATE cart SET user_id=?, product_id=?, quantity=? WHERE cart_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cart.getUserId());
        ps.setInt(2, cart.getProductId());
        ps.setInt(3, cart.getQuantity());
        ps.setInt(4, cart.getCartId());
        int rows = ps.executeUpdate();
        return rows > 0;
    }

    @Override
    public boolean deleteCart(int id) throws SQLException {
        String sql = "DELETE FROM cart WHERE cart_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        return rows > 0;
    }

    @Override
public List<Cart> getCartsByUserId(int userId) throws SQLException {
    List<Cart> list = new ArrayList<>();
    String sql = "SELECT * FROM cart WHERE user_id=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, userId);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        list.add(new Cart(
            rs.getInt("cart_id"),
            rs.getInt("user_id"),
            rs.getInt("product_id"),
            rs.getInt("quantity")
        ));
    }
    return list;
}

}
