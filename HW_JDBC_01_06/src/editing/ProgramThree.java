package editing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramThree {
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

            //добавление в таблицу 'Goods'
            int rows = statement.executeUpdate("INSERT INTO Goods(Category, ProductName, Price)" +
                                                    "VALUES (1, 'Клавиатура', 650), (2, 'Зарядное устройство', 230)");
                System.out.println("Добавленно строк в таблицу 'Goods': " + rows);

            //изменения в таблице 'Goods' колонке 'Price'
            int res = statement.executeUpdate("UPDATE Goods SET Price = price + 800 where ProductName = 'Монитор'");
                System.out.println("В таблице 'Goods' колонке 'Price' изменения: " + res);

            //удаление из таблицы 'Goods'
            int res1 = statement.executeUpdate("Delete from Goods where ProductId = 4");
                System.out.println("В таблице 'Goods' удаление: " + res1);

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
