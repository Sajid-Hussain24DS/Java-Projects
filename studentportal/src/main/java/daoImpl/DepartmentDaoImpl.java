package daoImpl;

import DAO.DepartmentDao;
import DATABASE.DB_Connection;
import Model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    // Connection object (singleton)
    private Connection conn = DB_Connection.getDbConnection();

    @Override
    public void addDepartment(Department dept) {
        String query = "INSERT INTO departments (dept_name, dept_code) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, dept.getDeptName());
            ps.setString(2, dept.getDeptCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department dept) {
        String query = "UPDATE departments SET dept_name=?, dept_code=? WHERE dept_id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, dept.getDeptName());
            ps.setString(2, dept.getDeptCode());
            ps.setInt(3, dept.getDeptId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(int deptId) {
        if (!canDelete(deptId)) {
            System.out.println("Cannot delete department. Students are assigned to it.");
            return;
        }

        String query = "DELETE FROM departments WHERE dept_id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, deptId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String query = "SELECT * FROM departments";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Department d = new Department();
                d.setDeptId(rs.getInt("dept_id"));
                d.setDeptName(rs.getString("dept_name"));
                d.setDeptCode(rs.getString("dept_code"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Department getDepartmentById(int deptId) {
        Department dept = null;
        String sql = "SELECT * FROM departments WHERE dept_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dept = new Department();
                dept.setDeptId(rs.getInt("dept_id"));
                dept.setDeptName(rs.getString("dept_name"));
                dept.setDeptCode(rs.getString("dept_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    /**
     * Checks if a department can be deleted.
     * Returns true if no student is assigned to this department.
     */
    public boolean canDelete(int deptId) {
        String sql = "SELECT COUNT(*) FROM students WHERE dept_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count == 0; // safe to delete
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }
}
