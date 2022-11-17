package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/katatest1_1_4",
                        "root",
                        "Ad724309!"
                );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return connection;
    }

    // реализуйте настройку соеденения с БД
}
