import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    private final String user = "postgres";
    private final String password = "Vladik";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> gerAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee")){

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");

                employees.add(new Employee(idEmployee, firstName, lastName, gender, age, cityId));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void getEmployeeById(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = " + id)){

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                System.out.println("ID сотрудника: " + idEmployee);

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");

                System.out.println("Имя: " + firstName);
                System.out.println("Фамилия: " + lastName);
                System.out.println("Пол: " + gender);
                System.out.println("Возраст: " + age);
                System.out.println("ID Города: " + cityId);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

    @Override
    public void createCityIdEmployee(int id, int cityId) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE employee SET city_id = " + cityId +" WHERE id =" + id)){

            System.out.println("Id города изменён.");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = " + id)){

            System.out.println("Сотрудник удалён из базы.");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

    @Override
    public void addingAnEmployee(String firstName, String lastName, String gender, int age, int cityId) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ("+ firstName + ","+ lastName + ","+ gender + ","+ age + "," + cityId +")")){

            System.out.println("Новый сотрудник добавлен в базу.");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }
}
