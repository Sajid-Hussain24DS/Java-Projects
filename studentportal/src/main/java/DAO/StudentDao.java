package DAO;

import  Model.Student;
import java.util.List;

public interface StudentDao {
    void addStudent(Student student); 
    Student getStudentById(int studentId);
    void deleteStudent(int studentId);
    void clearStudent(int StudentId);
     
   
    List<Student> getAllStudents();
    boolean insertStudent(Student student);

    public void updateStudent(Student student);
    
}
