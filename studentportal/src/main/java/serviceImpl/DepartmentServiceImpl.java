package serviceImpl;

import  DAO.DepartmentDao;
import DAO.StudentDao;
import daoImpl.DepartmentDaoImpl;
import  Model.Department;
import Model.Student;
import  Service.DepartmentService;
import daoImpl.StudentDaoImpl;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDao departmentDao = new DepartmentDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl(); 

    @Override
    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    @Override
    public void deleteDepartment(int deptId) {
        departmentDao.deleteDepartment(deptId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Override
public void updateDepartment(Department dept) {
    departmentDao.updateDepartment(dept);
}


    
@Override
public Department getDepartmentById(int deptId) {
    return departmentDao.getDepartmentById(deptId);
}
   @Override
public boolean canDelete(int deptId) {
    
    List<Student> students = studentDao.getAllStudents(); // studentDao ko inject karna hoga
    for (Student s : students) {
        if (s.getDepartment().getDeptId() == deptId) {
            return false; // koi student assigned hai
        }
    }
    return true; // delete possible
}}
