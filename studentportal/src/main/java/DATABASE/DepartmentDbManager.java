package DATABASE;

import Model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDbManager {

    public void addDepartment(Department department) {
        String sql = "INSERT INTO departments(dept_name, dept_code) VALUES (?, ?)";
        try (Connection connection = DB_Connection.getDbConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, department.getDeptName());
            ps.setString(2, department.getDeptCode());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Department added successfully");
            } else {
                System.out.println("Error occurred while adding Department");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Department getDepartmentById(int departmentId) {
        String sql = "SELECT * FROM departments WHERE dept_id = ?";
        try (Connection connection = DB_Connection.getDbConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, departmentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Department department = new Department();
                    department.setDeptId(rs.getInt("dept_id"));
                    department.setDeptName(rs.getString("dept_name"));
                    department.setDeptCode(rs.getString("dept_code"));
                    return department;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (Connection connection = DB_Connection.getDbConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Department department = new Department();
                department.setDeptId(rs.getInt("dept_id"));
                department.setDeptName(rs.getString("dept_name"));
                department.setDeptCode(rs.getString("dept_code"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public Department getDepartmentByDeptName(String deptName) {
        String sql = "SELECT * FROM departments WHERE dept_name = ?";
        try (Connection connection = DB_Connection.getDbConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, deptName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Department department = new Department();
                    department.setDeptId(rs.getInt("dept_id"));
                    department.setDeptName(rs.getString("dept_name"));
                    department.setDeptCode(rs.getString("dept_code"));
                    return department;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
