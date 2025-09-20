package serviceImpl;

import dao.OrderDetailDao;
import daoImpl.OrderDetailDaoImpl;
import model.OrderDetail;
import service.OrderDetailService;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDao orderDetailDao;

    public OrderDetailServiceImpl() throws SQLException {
        this.orderDetailDao = new OrderDetailDaoImpl();
    }

    @Override
    public void addOrderDetails(OrderDetail orderDetail) throws SQLException {
        orderDetailDao.addOrderDetail(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailsById(int id) throws SQLException {
        return orderDetailDao.getOrderDetailById(id);
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() throws SQLException {
        return orderDetailDao.getAllOrderDetails();
    }

    @Override
    public void updateOrderDetails(OrderDetail orderDetail) throws SQLException {
        orderDetailDao.updateOrderDetail(orderDetail);
    }

    @Override
    public void deleteOrderDetails(int id) throws SQLException {
        orderDetailDao.deleteOrderDetail(id);
    }
}
