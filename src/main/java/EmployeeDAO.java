import java.util.List;

public interface EmployeeDAO {
    List<Employee> gerAllEmployees();
    void getEmployeeById(int id);
    void createCityIdEmployee(int id, int cityId);
    void deleteEmployee(int id);
    void addingAnEmployee(String firstName, String lastName, String gender, int age, int cityId);
}
