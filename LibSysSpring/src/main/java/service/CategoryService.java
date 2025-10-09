package  service;

import  model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);
    Category getCategoryById(int categoryId);
    List<Category> getAllCategories();
    void goBack();
}
