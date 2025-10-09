package dao;

import java.sql.SQLException;
import model.Category;
import java.util.List;

public interface CategoryDao {
    boolean addCategory(Category category)throws SQLException;
    Category getCategoryById(int id)throws SQLException;
    List<Category> getAllCategories()throws SQLException;
    boolean updateCategory(Category category)throws SQLException;
    boolean deleteCategory(int id)throws SQLException;
}
