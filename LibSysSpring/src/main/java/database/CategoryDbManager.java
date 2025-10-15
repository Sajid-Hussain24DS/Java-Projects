package  database;

import model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import database.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CategoryDbManager {


    @Autowired
    private DBConnection dbConnection;
    @Autowired
    private ApplicationContext context;


    public void addCategory(Category category) {
        String sql = "INSERT INTO lib_categories(category_name) VALUES (?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryName());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Category added successfully");
            } else {
                System.out.println("Error occurred while adding Category");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Category getCategoryById(int categoryId) {
        String sql = "SELECT * FROM lib_categories WHERE category_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Category category = context.getBean(Category.class);
                    category.setCategoryId(rs.getInt("category_id"));
                    category.setCategoryName(rs.getString("category_name"));
                    return category;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM lib_categories";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category category = context.getBean(Category.class);
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category getCategoryByName(String categoryName) {
        String sql = "SELECT * FROM lib_categories WHERE category_name = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoryName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Category category = context.getBean(Category.class);
                    category.setCategoryId(rs.getInt("category_id"));
                    category.setCategoryName(rs.getString("category_name"));
                    return category;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}