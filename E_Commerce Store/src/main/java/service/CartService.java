package service;

import model.Cart;
import java.sql.SQLException;
import java.util.List;

public interface CartService {
    void addCart(Cart cart) throws SQLException;
    Cart getCartById(int id) throws SQLException;
    List<Cart> getAllCarts() throws SQLException;
    void updateCart(Cart cart) throws SQLException;
    void deleteCart(int id) throws SQLException;
}
