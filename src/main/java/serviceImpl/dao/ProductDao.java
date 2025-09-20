package dao;

import java.sql.SQLException;
import model.Product;
import java.util.List;

public interface ProductDao {
    boolean addProduct(Product product) throws SQLException;
    Product getProductById(int id)throws SQLException;
    List<Product> getAllProducts()throws SQLException;
    boolean updateProduct(Product product)throws SQLException;
    boolean deleteProduct(int id)throws SQLException;
}
