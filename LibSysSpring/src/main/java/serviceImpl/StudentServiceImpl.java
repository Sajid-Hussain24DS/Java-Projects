package serviceImpl;

import  dao.StudentDao;
import daoImpl.StudentDaoImpl;
 
import  model.Student;
import  service.StudentService;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDAO = new StudentDaoImpl();

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void goBack() {
        System.out.println("Back to Dashboard from Students...");
    }
}
