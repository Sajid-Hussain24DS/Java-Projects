package dao;

import java.sql.SQLException;
import model.Cart;
import java.util.List;

public interface CartDao {
    void addCart(Cart cart) throws SQLException;
    Cart getCartById(int id) throws SQLException;
    List<Cart> getAllCarts()throws SQLException;
    List<Cart> getCartsByUserId(int userId)throws SQLException;
    boolean updateCart(Cart cart) throws SQLException;
    boolean deleteCart(int id)throws SQLException;
}
