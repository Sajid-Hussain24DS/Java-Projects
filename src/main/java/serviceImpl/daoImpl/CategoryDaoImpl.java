package daoImpl;

import dao.CategoryDao;
import model.Category;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private Connection conn;

    public CategoryDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public boolean addCategory(Category category) throws SQLException {
        String sql = "INSERT INTO category(name) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, category.getName());
        int rows = ps.executeUpdate();
        return rows > 0;
        
    }

    @Override
    public Category getCategoryById(int id) throws SQLException {
        String sql = "SELECT * FROM category WHERE cat_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Category(
                rs.getInt("cat_id"),
                rs.getString("name")
            );
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() throws SQLException {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM category";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new Category(
                rs.getInt("cat_id"),
                rs.getString("name")
            ));
        }
        return list;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        String sql = "UPDATE category SET name=? WHERE cat_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, category.getName());
        ps.setInt(2, category.getCatId());
        int rows = ps.executeUpdate();
        return rows >0;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        String sql = "DELETE FROM category WHERE cat_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
       int rows =  ps.executeUpdate();
       return rows>0;
    }
}
