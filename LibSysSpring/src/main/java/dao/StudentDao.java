package  dao;

import  model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentDao {
    void addStudent(Student student);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
    
    


    void back();
}
