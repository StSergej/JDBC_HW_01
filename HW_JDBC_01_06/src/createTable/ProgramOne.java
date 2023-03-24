/*  Создать базу данных в Workbench и подключить к IntelliJIdea и создать тестовую таблицу.
    Заполнить ее данными с помощью запросов MySQL в IntelliJIdea.
    Используя JDBC написать пример выполнения всех запросов.
 */

package createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramOne {
    public static  void main(String[] args) {


            String URL = "jdbc:mysql://localhost:3306/test";
            String LOGIN = "root";
            String PASSWORD = "root";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
            System.out.println("-----------------------");

        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;


        try{
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();


            String sqlCommand1 = "CREATE TABLE Categories (CategoryId  INT auto_increment primary key,  \n" +
                                                          "CategoryName VARCHAR(50) NOT NULL)";

            String sqlCommand2 = "CREATE TABLE Goods (ProductId INT auto_increment primary key, \n" +
                            "Category  INT NOT NULL, ProductName  VARCHAR(50) NOT NULL, Price  INT NULL)";


            statement.executeUpdate(sqlCommand1);
                System.out.println("Создана таблица 'Categories'");

            statement.executeUpdate(sqlCommand2);
                System.out.println("Создана таблица 'Goods'");


        } catch (SQLException ex) {
            ex.printStackTrace();

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
