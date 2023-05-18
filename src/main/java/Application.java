import java.sql.*;
import java.util.List;

public class Application {
    public static void main (String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.gerAllEmployees();

        for (Employee employee : employees) {
            System.out.println("Id сотруника: " + employee.getId());
            System.out.println("Имя: " + employee.getFirstName());
            System.out.println("Фамилия: " + employee.getLastName());
            System.out.println("Пол: " + employee.getGender());
            System.out.println("Возраст: " + employee.getAge());
            System.out.println("Id города: " + employee.getCityId());
        }

        System.out.println("Проверяю методы:");
        System.out.println();
        System.out.println("Получение объекта по Id:");
        employeeDAO.getEmployeeById(6);
        System.out.println("Содание объекта:");
        employeeDAO.addingAnEmployee("Oleg", "Olegov", "man", 20, 1);
        employeeDAO.getEmployeeById(7);
        System.out.println("Изменение объекта:");
        employeeDAO.createCityIdEmployee(7, 2);
        System.out.println("Удаление объекта:");
        employeeDAO.deleteEmployee(7);
    }
}
