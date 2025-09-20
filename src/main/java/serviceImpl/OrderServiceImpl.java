package serviceImpl;

import dao.OrderDao;
import daoImpl.OrderDaoImpl;
import model.Order;
import service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl() throws SQLException {
        this.orderDao = new OrderDaoImpl();
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        orderDao.addOrder(order);
    }

    @Override
    public Order getOrderById(int id) throws SQLException {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        return orderDao.getAllOrders();
    }

    @Override
    public void updateOrder(Order order) throws SQLException {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(int id) throws SQLException {
        orderDao.deleteOrder(id);
    }
}
