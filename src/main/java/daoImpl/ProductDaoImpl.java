package daoImpl;

import dao.ProductDao;
import model.Product;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection conn;

    public ProductDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public boolean addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products(name, price, quantity, image, category_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setInt(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.setString(4, product.getImage());
        ps.setInt(5, product.getCategoryId());
        int rows = ps.executeUpdate();
        return rows >0;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        String sql = "SELECT * FROM products WHERE p_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Product(
                rs.getInt("p_id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getString("image"),
                rs.getInt("category_id")
            );
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new Product(
                rs.getInt("p_id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getString("image"),
                rs.getInt("category_id")
            ));
        }
        return list;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        String sql = "UPDATE products SET name=?, price=?, quantity=?, image=?, category_id=? WHERE p_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setInt(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.setString(4, product.getImage());
        ps.setInt(5, product.getCategoryId());
        ps.setInt(6, product.getPId());
        int rows = ps.executeUpdate();
        return rows >0;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE p_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
       int rows = ps.executeUpdate();
        return rows >0;
    }
}
