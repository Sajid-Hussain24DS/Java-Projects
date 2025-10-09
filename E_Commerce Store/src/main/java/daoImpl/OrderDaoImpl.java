package daoImpl;

import dao.OrderDao;
import model.Order;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private Connection conn;

    public OrderDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public boolean addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders(customer_phone, total_price, order_no, date) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, order.getCustomerPhone());
        ps.setInt(2, order.getTotalPrice());
        ps.setString(3, order.getOrderNo());
        ps.setDate(4, order.getDate());
        int rows = ps.executeUpdate();
        return rows >0;
    }

    @Override
    public Order getOrderById(int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE order_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Order(
                rs.getInt("order_id"),
                rs.getString("customer_phone"),
                rs.getInt("total_price"),
                rs.getString("order_no"),
                rs.getDate("date")
            );
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new Order(
                rs.getInt("order_id"),
                rs.getString("customer_phone"),
                rs.getInt("total_price"),
                rs.getString("order_no"),
                rs.getDate("date")
            ));
        }
        return list;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        String sql = "UPDATE orders SET customer_phone=?, total_price=?, order_no=?, date=? WHERE order_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, order.getCustomerPhone());
        ps.setInt(2, order.getTotalPrice());
        ps.setString(3, order.getOrderNo());
        ps.setDate(4, order.getDate());
        ps.setInt(5, order.getOrderId());
        int rows = ps.executeUpdate();
        return rows>0;
    }

    @Override
    public boolean deleteOrder(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE order_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
       int rows = ps.executeUpdate();
        return rows>0;
    }
}
