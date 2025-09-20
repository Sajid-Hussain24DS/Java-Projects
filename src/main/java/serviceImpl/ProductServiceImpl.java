package serviceImpl;

import dao.ProductDao;
import daoImpl.ProductDaoImpl;
import model.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() throws SQLException {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        return productDao.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productDao.getAllProducts();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        productDao.deleteProduct(id);
    }
}
