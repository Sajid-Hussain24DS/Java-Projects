package serviceImpl;

import DAO.StudentDao;
import daoImpl.StudentDaoImpl;
import Model.Student;
import Service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDao.deleteStudent(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}
