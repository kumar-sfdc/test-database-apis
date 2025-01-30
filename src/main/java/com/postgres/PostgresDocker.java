package com.postgres;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresDocker {
    private static PostgreSQLContainer<?> postgresContainer;

    public static void startPostgres() {
        if (postgresContainer == null) {
            postgresContainer = new PostgreSQLContainer<>("postgres:latest");
            postgresContainer.start();
        }
    }

    public static PostgreSQLContainer<?> getPostgresContainer() {
        return postgresContainer;
    }

    public static void stopPostgres() {
        if (postgresContainer != null) {
            postgresContainer.stop();
        }
    }
}
