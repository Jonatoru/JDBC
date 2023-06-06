import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public List<Employee> gerAllEmployees() {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "FROM Employee";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }
    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }
    @Override
    public void createEmployee(Employee employee, int id) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.find(Employee.class, id);
        employee.setAge(employee.getAge());
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        employee =entityManager.find(Employee.class, employee.getId());
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }
    @Override
     public Integer addEmployee(Employee employee) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee.getId();
    }
}
