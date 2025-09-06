package daoImpl;

import DAO.StudentDao;
import DATABASE.DB_Connection;
import DATABASE.DepartmentDbManager;
import Model.Department;
import Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private Connection conn = DB_Connection.getDbConnection();
    private DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

    @Override
     public void addStudent(Student student) {
        if (student == null || student.getDepartment() == null) {
            System.out.println("Invalid student or department.");
            return;
        }

        String sql = "INSERT INTO students (name, age, cnic, roll_number, email, gender, dept_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getCnic());
            stmt.setString(4, student.getRollNumber());
            stmt.setString(5, student.getEmail());
            stmt.setString(6, student.getGender());
            stmt.setInt(7, student.getDepartment().getDeptId());

            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding student:");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting student:");
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students";

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Student s = new Student();
            s.setStudentId(rs.getInt("student_id"));
            s.setName(rs.getString("name"));           
            s.setAge(rs.getInt("age"));                 
            s.setCnic(rs.getString("cnic"));            
            s.setRollNumber(rs.getString("roll_number"));
            s.setEmail(rs.getString("email"));          
            s.setGender(rs.getString("gender"));        

            int deptId = rs.getInt("dept_id");
            Department dept = departmentDao.getDepartmentById(deptId);
            s.setDepartment(dept);

            list.add(s);
        }
    } catch (SQLException e) {
        System.out.println("Error fetching students:");
        e.printStackTrace();
    }
    return list;
}


   @Override
    public boolean insertStudent(Student student) {
    if (student == null || student.getDepartment() == null) {
        System.out.println("Invalid student or department.");
        return false;
    }

    String sql = "INSERT INTO students (name, roll_number, dept_id) VALUES (?, ?, ?)";  

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getRollNumber());
        stmt.setInt(3, student.getDepartment().getDeptId());

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error inserting student:");
        e.printStackTrace();
        return false;
    }
    }

 @Override
 public Student getStudentById(int studentId) {
    String sql = "SELECT * FROM students WHERE student_id = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, studentId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setCnic(rs.getString("cnic"));
                s.setRollNumber(rs.getString("roll_number"));
                s.setEmail(rs.getString("email"));
                s.setGender(rs.getString("gender"));
                int deptId = rs.getInt("dept_id");
                Department dept = departmentDao.getDepartmentById(deptId);
                s.setDepartment(dept);

                return s;  
            }
        }
    } catch (SQLException e) {
        System.out.println("Error fetching student by ID:");
        e.printStackTrace();
    }
    return null; // agar student na mile
}

@Override
public void updateStudent(Student student) {
    String sql = "UPDATE students SET name=?, age=?, cnic=?, roll_number=?, email=?, gender=?, dept_id=? WHERE student_id=?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, student.getName());
        stmt.setInt(2, student.getAge());
        stmt.setString(3, student.getCnic());
        stmt.setString(4, student.getRollNumber());
        stmt.setString(5, student.getEmail());

        // fix gender issue
        String gender = student.getGender();
        if (gender != null) {
            if (gender.equalsIgnoreCase("male")) {
                stmt.setString(6, "Male");
            } else {
                stmt.setString(6, "Female");
            }
        } else {
            stmt.setString(6, "Male"); 
        }

        stmt.setInt(7, student.getDepartment().getDeptId());
        stmt.setInt(8, student.getStudentId());

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Update failed, student not found.");
        }
    } catch (SQLException e) {
        System.out.println("Error updating student:");
        e.printStackTrace();
    }}

    @Override
    public void clearStudent(int StudentId) {
        
    }
     
}

