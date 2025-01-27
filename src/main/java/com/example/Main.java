package com.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) {
        // Start Cassandra
        CassandraDocker.startCassandra();
        CassandraHelper.initialize();

        // Configure Jersey
        final ResourceConfig resourceConfig = new ResourceConfig()
                .packages("com.example")
                .register(JacksonFeature.class);
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);

        System.out.println("Server running at: " + BASE_URI);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdownNow();
            CassandraHelper.close();
            CassandraDocker.stopCassandra();
        }));
    }
}