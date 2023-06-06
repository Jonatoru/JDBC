import java.sql.*;

public class Application {
    public static void main (String[] args) throws SQLException {
        Employee employee = new Employee("Gerald", "Friman", "man", 50, 3);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.gerAllEmployees().forEach(System.out::println);
        System.out.println("Проверяю методы:");
        System.out.println();
        System.out.println("Получение объекта по Id:");
        employeeDAO.getEmployeeById(6);
        System.out.println("Содание объекта:");
        employeeDAO.addEmployee(employee);
        System.out.println(employeeDAO.gerAllEmployees());
        System.out.println("Изменение объекта:");
        employeeDAO.createEmployee(employee, employee.getId());
        System.out.println("Удаление объекта:");
        employeeDAO.deleteEmployee(employee);
        System.out.println(employeeDAO.gerAllEmployees());


    }
}
