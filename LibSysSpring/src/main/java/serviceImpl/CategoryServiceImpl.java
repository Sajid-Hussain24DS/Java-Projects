package  serviceImpl;

import  dao.CategoryDao;
import daoImpl.CategoryDaoImpl;
import  service.CategoryService;
import java.util.List;
import model.Category;
 

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDAO = new CategoryDaoImpl();

    @Override
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryDAO.deleteCategory(categoryId);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryDAO.getCategoryById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public void goBack() {
        System.out.println("Back to Dashboard from Categories...");
    }
}
