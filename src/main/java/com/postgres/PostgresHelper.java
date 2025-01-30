package com.postgres;

import org.testcontainers.containers.PostgreSQLContainer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresHelper {
    private static Connection connection;
    private static PostgreSQLContainer<?> postgresContainer;

    public static void initialize() {
        if (connection == null) {
            postgresContainer = PostgresDocker.getPostgresContainer();
            try {
                connection = DriverManager.getConnection(postgresContainer.getJdbcUrl(),
                        postgresContainer.getUsername(), postgresContainer.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        setupDatabase();
        insertData();
    }

    private static void setupDatabase() {
        String sqlFilePath = "tables/insight_type.sql";
        executeFromFile(sqlFilePath);
    }

    private static void insertData() {
        String sqlFilePath = "data/insighttype.sql";
        executeFromFile(sqlFilePath);
    }

    private static void executeFromFile(String sqlFilePath) {
        try (InputStream inputStream = PostgresHelper.class.getClassLoader().getResourceAsStream(sqlFilePath)) {
            if (inputStream == null) {
                System.out.println("SQL file not found in the resources directory!");
                return;
            }

            // Read the SQL file content
            String sql = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            try (Statement stmt = connection.createStatement()) {
                // Execute the SQL query
                stmt.executeUpdate(sql);
                System.out.println("SQL file executed successfully!");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    // Close the connection
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
