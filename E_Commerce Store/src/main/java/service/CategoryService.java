package service;

import model.Category;
import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    void addCategory(Category category) throws SQLException;
    Category getCategoryById(int id) throws SQLException;
    List<Category> getAllCategories() throws SQLException;
    void updateCategory(Category category) throws SQLException;
    void deleteCategory(int id) throws SQLException;
}
