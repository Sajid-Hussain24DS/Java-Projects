package daoImpl;

import Config.AppConfig;
import dao.StudentDao;
import model.Student;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
@Repository
public class StudentDaoImpl implements StudentDao {


    private final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    public Student getStudent(){
        return context.getBean(Student.class);
    }
    private Connection conn;
    public StudentDaoImpl() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database!");
        }
    }
    

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO lib_students (name, age, roll_number, email, contact) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getRollNumber());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getContact());
            ps.executeUpdate();
            System.out.println("✅ Student added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM lib_students WHERE student_Id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student student = getStudent();
                student.setStudentId(rs.getInt("student_Id"));
                student.setName(rs.getString("name"));
                student .setAge(rs.getInt("age"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setEmail(rs.getString("email"));
                student.setContact(rs.getString("contact"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM lib_students";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = getStudent();
                student.setStudentId(rs.getInt("student_Id"));
                student.setName(rs.getString("name"));
                student .setAge(rs.getInt("age"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setEmail(rs.getString("email"));
                student.setContact(rs.getString("contact"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE lib_students SET name=?, age=?, roll_number=?, email=?, contact=? WHERE student_Id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());  
            ps.setString(3, student.getRollNumber());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getContact());
            ps.setInt(6, student.getStudentId());
            ps.executeUpdate();
            System.out.println("✅ Student updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM lib_students WHERE student_Id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.executeUpdate();
            System.out.println("✅ Student deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void back() {
        System.out.println("⬅ Going back to previous menu...");
    }
}
