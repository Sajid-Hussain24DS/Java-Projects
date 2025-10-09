package serviceImpl;

import dao.CategoryDao;
import daoImpl.CategoryDaoImpl;
import model.Category;
import service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public CategoryServiceImpl() throws SQLException {
        this.categoryDao = new CategoryDaoImpl();
    }

    @Override
    public void addCategory(Category category) throws SQLException {
        categoryDao.addCategory(category);
    }

    @Override
    public Category getCategoryById(int id) throws SQLException {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() throws SQLException {
        return categoryDao.getAllCategories();
    }

    @Override
    public void updateCategory(Category category) throws SQLException {
        categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(int id) throws SQLException {
        categoryDao.deleteCategory(id);
    }
}
