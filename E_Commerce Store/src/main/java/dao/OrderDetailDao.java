package dao;

import java.sql.SQLException;
import model.OrderDetail;
import java.util.List;

public interface OrderDetailDao {
    boolean addOrderDetail(OrderDetail orderDetail)throws SQLException ;
    OrderDetail getOrderDetailById(int id)throws SQLException ;
    List<OrderDetail> getAllOrderDetails()throws SQLException ;
    List<OrderDetail> getOrderDetailsByOrderId(int orderId)throws SQLException ;
    boolean updateOrderDetail(OrderDetail orderDetail)throws SQLException ;
    boolean deleteOrderDetail(int id)throws SQLException ;
}
