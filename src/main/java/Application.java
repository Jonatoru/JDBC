import java.sql.*;

public class Application {
    public static void main (String[] args) throws SQLException {
        City city = new City("Sochi");
        City city1 = new City("ABC");
        Employee employee = new Employee("Gerald", "Friman", "man", 50, city);
        Employee employee1 = new Employee("Gendalf", "Belyi", "man", 53, city);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();
        cityDAO.gerAllCity().forEach(System.out::println);
        employeeDAO.gerAllEmployees().forEach(System.out::println);

        System.out.println("Содание объектов:");
        cityDAO.addCity(city);
        employeeDAO.addEmployee(employee);
        employeeDAO.addEmployee(employee1);
        System.out.println(cityDAO.gerAllCity());
        System.out.println(employeeDAO.gerAllEmployees());

        System.out.println("Изменение сотрудника в городе:");
        cityDAO.createCity(city1, employee.getId());
        System.out.println("Проверяю:");
        employeeDAO.getEmployeeById(employee.getId());

        System.out.println("Удаление объекта:");
        cityDAO.deleteCity(city);
        System.out.println(employeeDAO.gerAllEmployees());
    }
}
