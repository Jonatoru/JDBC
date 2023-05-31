import java.util.List;

public interface EmployeeDAO {
    List<Employee> gerAllEmployees();
    Employee getEmployeeById(int id);
    void createEmployee(Employee employee, int id);
    void deleteEmployee(Employee employee);
    Integer addEmployee(Employee employee);
}
