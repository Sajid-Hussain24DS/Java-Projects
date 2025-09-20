package dao;

import model.Category;
import java.util.List;

public interface CategoryDao {
    void addCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    void updateCategory(Category category);
    void deleteCategory(int id);

    void back();
}
