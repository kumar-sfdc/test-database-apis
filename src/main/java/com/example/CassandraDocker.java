package com.example;

import org.testcontainers.containers.CassandraContainer;

public class CassandraDocker {
    private static CassandraContainer<?> cassandraContainer;

    public static void startCassandra() {
        if (cassandraContainer == null) {
            cassandraContainer = new CassandraContainer<>("cassandra:latest");
            cassandraContainer.start();
        }
    }

    public static String getHost() {
        return cassandraContainer.getHost();
    }

    public static int getPort() {
        return cassandraContainer.getFirstMappedPort();
    }

    public static void stopCassandra() {
        if (cassandraContainer != null) {
            cassandraContainer.stop();
        }
    }
}
