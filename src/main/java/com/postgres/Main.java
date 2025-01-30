package com.postgres;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) {
        // Start Postgres
        PostgresDocker.startPostgres();
        PostgresHelper.initialize();

        // Configure Jersey
        final ResourceConfig resourceConfig = new ResourceConfig()
                .packages("com.postgres")
                .register(JacksonFeature.class);
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);

        System.out.println("Server running at: " + BASE_URI);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdownNow();
            PostgresHelper.close();
            PostgresDocker.stopPostgres();
        }));
    }
}
