package dao;

import java.sql.SQLException;
import model.Order;
import java.util.List;

public interface OrderDao {
    boolean addOrder(Order order)throws SQLException;
    Order getOrderById(int id)throws SQLException;
    List<Order> getAllOrders()throws SQLException;
    boolean updateOrder(Order order)throws SQLException;
    boolean deleteOrder(int id)throws SQLException;
}
