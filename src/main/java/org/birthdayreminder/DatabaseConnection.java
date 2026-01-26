package org.birthdayreminder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {
    private static final String DB_NAME = "testbd";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + DB_NAME;
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("ssl", "false");
            connection = DriverManager.getConnection(URL, props);
            createTableIfNotExists();

            System.out.println("Подключение к БД установлено");

        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер базы данных не найден");

        } catch (SQLException e) {
            System.out.println("Ошибка подключение к базе данных");
        }
    }

    private static void createTableIfNotExists() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS birthdays (
                id SERIAL PRIMARY KEY,
                full_name VARCHAR(100) NOT NULL UNIQUE,
                birth_date DATE NOT NULL
            )
            """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица создана");
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("ssl", "false");
            connection = DriverManager.getConnection(URL, props);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Соединение с базой данный закрыто");
            } catch (SQLException e) {
                System.out.println("Ошибка при закрытии соединения");
            }
        }
    }
}