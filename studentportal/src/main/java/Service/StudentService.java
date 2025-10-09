package  Service;

import Model.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(int studentId);
    List<Student> getAllStudents();
}
