import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public List<Employee> gerAllEmployees() {
        try (Session session = Hibernate_EntityManagerFactory.getSessionFactory().openSession()) {
           return session.createQuery("FROM Employee").list();
        }
    }
    @Override
    public Employee getEmployeeById(int id) {
        try (Session session = Hibernate_EntityManagerFactory.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }
    @Override
    public void createEmployee(Employee employee, int id) {
        try (Session session = Hibernate_EntityManagerFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee.setId(id);
            session.update(employee);
            transaction.commit();
        }
    }
    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = Hibernate_EntityManagerFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
    @Override
     public Integer addEmployee(Employee employee) {
        Integer id;
        try (Session session = Hibernate_EntityManagerFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(employee);
            transaction.commit();
        }
        return id;
    }
}
