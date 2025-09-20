package service;

import model.OrderDetail;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailService {
    void addOrderDetails(OrderDetail orderDetails) throws SQLException;
    OrderDetail getOrderDetailsById(int id) throws SQLException;
    List<OrderDetail> getAllOrderDetails() throws SQLException;
    void updateOrderDetails(OrderDetail orderDetails) throws SQLException;
    void deleteOrderDetails(int id) throws SQLException;
}
