package daoimpl;

import dao.StudentDao;
import model.Student;
import database.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class StudentDaoImpl implements StudentDao {
    @Autowired
    public ApplicationContext context;
        private final JdbcTemplate jdbcTemplate;

        @Autowired
        public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }


        @Override
        public void addStudent(Student student) {
            String sql = "INSERT INTO lib_students (name, age, roll_number, email, contact) VALUES (?, ?, ?, ?, ?)";
            int rows = jdbcTemplate.update(sql,
                    student.getName(),
                    student.getAge(),
                    student.getRollNumber(),
                    student.getEmail(),
                    student.getContact()
            );
            if (rows > 0) {
                System.out.println("Student added successfully.");
            }
        }

        @Override
        public Student getStudentById(int studentId) {
            String sql = "SELECT * FROM lib_students WHERE student_Id = ?";
            try {
                return jdbcTemplate.queryForObject(sql, new Object[]{studentId}, (rs, rowNum) -> {
                    Student student = context.getBean(Student.class);
                    student.setStudentId(rs.getInt("student_Id"));
                    student.setName(rs.getString("name"));
                    student.setAge(rs.getInt("age"));
                    student.setRollNumber(rs.getString("roll_number"));
                    student.setEmail(rs.getString("email"));
                    student.setContact(rs.getString("contact"));
                    return student;
                });
            } catch (EmptyResultDataAccessException e) {
                return null;
            }}


        @Override
        public List<Student> getAllStudents() {
            String sql = "SELECT * FROM lib_students";
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Student student = context.getBean(Student.class);
                student.setStudentId(rs.getInt("student_Id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setEmail(rs.getString("email"));
                student.setContact(rs.getString("contact"));
                return student;
            });
        }


        @Override
        public void updateStudent(Student student) {
            String sql = "UPDATE lib_students SET name = ?, age = ?, roll_number = ?, email = ?, contact = ? WHERE student_Id = ?";
            int rows = jdbcTemplate.update(sql,
                    student.getName(),
                    student.getAge(),
                    student.getRollNumber(),
                    student.getEmail(),
                    student.getContact(),
                    student.getStudentId()
            );
            if (rows > 0) {
                System.out.println("✅ Student updated successfully.");
            }
        }


        @Override
        public void deleteStudent(int studentId) {
            String sql = "DELETE FROM lib_students WHERE student_Id = ?";
            int rows = jdbcTemplate.update(sql, studentId);
            if (rows > 0) {
                System.out.println("✅ Student deleted successfully.");
            }
        }


        @Override
        public void back() {
            System.out.println("⬅ Going back to previous menu...");
        }
    }
