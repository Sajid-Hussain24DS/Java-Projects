package dao;

import model.Category;
import java.util.List;

public interface CategoryDao {
    int addCategory(Category category);        // int return type
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    boolean updateCategory(Category category); // boolean return type
    boolean deleteCategory(int id);           // boolean return type
    Category getCategoryByName(String categoryName);
    void back();
}