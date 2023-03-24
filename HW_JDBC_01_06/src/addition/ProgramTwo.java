package addition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramTwo {
    public static void main(String[] args) {

            String URL = "jdbc:mysql://localhost:3306/test";
            String LOGIN = "root";
            String PASSWORD = "root";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");

        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            //заполнение таблицы 'Categories'
            int rows1 = statement.executeUpdate("INSERT INTO Categories(CategoryName)" +
                                                    "VALUES ('Комплектующие ПК'),('Мобильные устройства')");
            System.out.println("Добавленно строк в таблицу 'Categories': " + rows1);

            //заполнение таблицы 'Goods'
            int rows2 = statement.executeUpdate("INSERT INTO Goods(Category, ProductName, Price)" +
                            "VALUES(1, 'Системный блок', 10000), (1, 'Монитор', 3500), (2, 'Смартфон', 8500)");
            System.out.println("Добавленно строк в таблицу 'Goods' " + rows2);

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
    }
}
