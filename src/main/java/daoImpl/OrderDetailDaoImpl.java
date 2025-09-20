package daoImpl;

import dao.OrderDetailDao;
import model.OrderDetail;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    private Connection conn;

    public OrderDetailDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }
        @Override
    public boolean addOrderDetail(OrderDetail orderDetail) throws SQLException {
        String sql = "INSERT INTO order_details(product_id, price, quantity, order_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderDetail.getProductId());
        ps.setInt(2, orderDetail.getPrice());
        ps.setInt(3, orderDetail.getQuantity());
        ps.setInt(4, orderDetail.getOrderId());
        int rows = ps.executeUpdate();
        return rows > 0;
    }

    @Override
    public OrderDetail getOrderDetailById(int id) throws SQLException {
        String sql = "SELECT * FROM order_details WHERE od_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new OrderDetail(
                rs.getInt("od_id"),
                rs.getInt("product_id"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getInt("order_id")
            );
        }
        return null;
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM order_details";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new OrderDetail(
                rs.getInt("od_id"),
                rs.getInt("product_id"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getInt("order_id")
            ));
        }
        return list;
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM order_details WHERE order_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new OrderDetail(
                rs.getInt("od_id"),
                rs.getInt("product_id"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getInt("order_id")
            ));
        }
        return list;
    }

    @Override
    public boolean updateOrderDetail(OrderDetail orderDetail) throws SQLException {
        String sql = "UPDATE order_details SET product_id=?, price=?, quantity=?, order_id=? WHERE od_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderDetail.getProductId());
        ps.setInt(2, orderDetail.getPrice());
        ps.setInt(3, orderDetail.getQuantity());
        ps.setInt(4, orderDetail.getOrderId());
        ps.setInt(5, orderDetail.getOdId());
        int rows = ps.executeUpdate();
        return rows > 0;
    }

    @Override
    public boolean deleteOrderDetail(int id) throws SQLException {
        String sql = "DELETE FROM order_details WHERE od_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        return rows > 0;
    }
    }