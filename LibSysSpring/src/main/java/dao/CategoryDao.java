package dao;

import model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CategoryDao {
    void addCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    void updateCategory(Category category);
    void deleteCategory(int id);

    void back();
}
