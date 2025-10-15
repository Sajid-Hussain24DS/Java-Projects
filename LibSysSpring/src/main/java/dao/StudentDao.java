package  dao;

import  model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
    
    


    void back();
}
