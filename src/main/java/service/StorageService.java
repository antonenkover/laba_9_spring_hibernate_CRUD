package service;

import model.Department;
import dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("storageService")
public class StorageService {

    @Autowired
    DepartmentDao departmentDao;

    @Transactional
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Transactional
    public Department getDepartment(int id) {
        return departmentDao.getDepartment(id);
    }

    @Transactional
    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    @Transactional
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(Department);

    }

    @Transactional
    public void deleteDepartment(int id) {
        departmentDao.deleteDepartment(id);
    }
}
