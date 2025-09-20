package serviceImpl;

import dao.CartDao;
import daoImpl.CartDaoImpl;
import model.Cart;
import service.CartService;

import java.sql.SQLException;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao;

    public CartServiceImpl() throws SQLException {
        this.cartDao = new CartDaoImpl();
    }

    @Override
    public void addCart(Cart cart) throws SQLException {
        cartDao.addCart(cart);
    }

    @Override
    public Cart getCartById(int id) throws SQLException {
        return cartDao.getCartById(id);
    }

    @Override
    public List<Cart> getAllCarts() throws SQLException {
        return cartDao.getAllCarts();
    }

    @Override
    public void updateCart(Cart cart) throws SQLException {
        cartDao.updateCart(cart);
    }

    @Override
    public void deleteCart(int id) throws SQLException {
        cartDao.deleteCart(id);
    }
}
