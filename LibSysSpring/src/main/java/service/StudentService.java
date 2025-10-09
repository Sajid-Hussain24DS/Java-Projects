package  service;

import  model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
    void goBack();
}
