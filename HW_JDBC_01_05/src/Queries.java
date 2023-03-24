import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Queries {

     public static final String URL = "jdbc:mysql://localhost:3306/myJoinsDB";
     public static final String  LOGIN = "root";
     public static final String PASSWORD = "root";

    Connection connection = null;
    Statement statement = null;


    //Контактные данные сотрудников
    public List<Employees> getAllEmployees() {

        List<Employees> employees = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select employees.id_number, full_name, telephone, address\n" +
                                            "from employees\n" +
                                            "INNER JOIN personal_data on employees.id_number = personal_data.id_number;");

            while (resultSet.next()) {
                int id_number = resultSet.getInt(1);
                String full_name = resultSet.getString(2);
                String telephone = resultSet.getString("telephone");
                String address = resultSet.getString("address");

                Employees employee = new Employees(id_number, full_name, telephone, address);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    //Данные о дате рождения всех холостых сотрудников
    public List<Employees> getAllMarital() {

        List<Employees> employees = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("select full_name, birthday, family_status\n" +
                    "from employees\n" +
                    "INNER JOIN personal_data on employees.id_number = personal_data.id_number\n" +
                    "where family_status = 'холост';");

            while (resultSet.next()) {
                String full_name = resultSet.getString(1);
                String birthday = resultSet.getString("birthday");
                String family_status = resultSet.getString("family_status");

                Employees employee = new Employees(full_name, birthday, family_status);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    //данные обо всех менеджерах компании
    public List<Employees> getPosition() {

        List<Employees> employees = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select employees.id_number, full_name, position, birthday, telephone\n" +
                        "from employees\n" +
                        "inner join personal_data on personal_data.id_number = employees.id_number\n" +
                        "inner join proprietary_data on employees.id_number = proprietary_data.id_number\n" +
                        "where position = 'менеджер';");

            while (resultSet.next()) {
                int id_number = resultSet.getInt(1);
                String full_name = resultSet.getString(2);
                String position = resultSet.getString("position");
                String birthday = resultSet.getString("birthday");
                String telephone = resultSet.getString("telephone");

                Employees employee = new Employees(id_number, full_name, position, birthday, telephone);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }
}


