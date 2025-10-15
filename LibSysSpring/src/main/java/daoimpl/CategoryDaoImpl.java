package daoimpl;

import dao.CategoryDao;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryDaoImpl implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addCategory(Category category) {
        if (category == null || category.getCategoryName() == null || category.getCategoryName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }

        String sql = "INSERT INTO lib_categories (category_name) VALUES (?)";
        return jdbcTemplate.update(sql, category.getCategoryName().trim());
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM lib_categories WHERE category_id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Category category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                return category;
            }, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM lib_categories";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public boolean updateCategory(Category category) {
        if (category == null || category.getCategoryId() <= 0) {
            throw new IllegalArgumentException("Invalid category data");
        }

        String sql = "UPDATE lib_categories SET category_name = ? WHERE category_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, category.getCategoryName(), category.getCategoryId());

        if (rowsAffected > 0) {
            System.out.println("Category updated successfully.");
            return true;
        } else {
            System.out.println("Category not found with ID: " + category.getCategoryId());
            return false;
        }
    }

    @Override
    public boolean deleteCategory(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid category ID");
        }

        String sql = "DELETE FROM lib_categories WHERE category_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);

        if (rowsAffected > 0) {
            System.out.println("Category deleted successfully.");
            return true;
        } else {
            System.out.println("Category not found with ID: " + id);
            return false;
        }
    }


    public Category getCategoryByName(String categoryName) {
        if (categoryName == null || categoryName.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }

        String sql = "SELECT * FROM lib_categories WHERE category_name = ?";

        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Category category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                return category;
            }, categoryName.trim());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void back() {
        System.out.println("⬅ Going back to previous menu...");
    }


}