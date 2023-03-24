package gettingData;

import java.sql.*;

public class ProgramFour {
    public static void main(String[] args) {

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

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            //данные из таблицы 'Categories'
            System.out.println("Таблица 'Categories':");
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM Categories");
            while(resultSet1.next()){
                int id = resultSet1.getInt("CategoryId");
                String name = resultSet1.getString("CategoryName");

                System.out.println(id + "  " + name);
            }

            System.out.println("-------------------------");
            System.out.println("Таблица 'Goods':");

            //данные из таблицы 'Goods'
            statement = connection.createStatement();
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM Goods");
            while (resultSet2.next()){
                int id = resultSet2.getInt("ProductId");
                int category = resultSet2.getInt("Category");
                String name = resultSet2.getString("ProductName");
                int price = resultSet2.getInt("Price");

                System.out.println(id + "  " + category + "  " + name + "  " + price);

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
    }
}
