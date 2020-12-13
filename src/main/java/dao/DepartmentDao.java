package dao;

import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<Department> getAllDepartments() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> departmentList = session.createQuery("from Department").list();
        return departmentList;
    }

    public Department getDepartment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department department = (Department) session.get(Department.class, id);
        return department;
    }

    public Department addDepartment(Department department) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(department);
        return department;
    }

    public void updateDepartment(Department department) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(department);
    }

    public void deleteDepartment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department p = (Department) session.load(Department.class, id);
        if (null != p) {
            session.delete(p);
        }
    }
}
