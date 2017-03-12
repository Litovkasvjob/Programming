package ua.litovka.lection8_JDBC;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by SergLion on 10.02.2017.
 */
public class App {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.out.println("Не удалось загрузить драйвер");
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            //statement.execute("INSERT INTO animal (anim_name, anim_desc) VALUES ('name', 'desc');");
            //statement.executeUpdate("UPDATE animal SET anim_name = 'New name' WHERE id = 1;");
            //ResultSet res = statement.executeQuery("SELECT  * FROM animal;");
            //System.out.println(res);

            statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch1', 'desc');");
            statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch2', 'desc');");
            statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch3', 'desc');");

            statement.executeBatch();

            statement.clearBatch();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
