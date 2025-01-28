package com.example;

import com.datastax.oss.driver.api.core.CqlSession;
import com.salesforceiq.org_migration.test_framework.cassandra.CassandraTestUtils;

import java.net.InetSocketAddress;

public class CassandraHelper {
    private static CqlSession session;

    public static void initialize() {
        if (session == null) {
            session = CqlSession.builder()
                    .addContactPoint(new InetSocketAddress(CassandraDocker.getHost(), CassandraDocker.getPort()))
                    .withLocalDatacenter("datacenter1")
                    .build();

            // Create keyspace and table
            session.execute("CREATE KEYSPACE IF NOT EXISTS riq2 WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}");
            session.execute("USE riq2");

            // Create table if not exits
            session.execute(CassandraTestUtils.readCQLDumpFile("tables/orgtimelinepage.cql").get(0));
            session.execute(CassandraTestUtils.readCQLDumpFile("tables/scoped_data_policy.cql").get(0));

            // Insert sample data
            insertDataIntoOrgTimeLinePage("data/emails.cql");
            insertDataIntoOrgTimeLinePage("data/ecivideospolicy.cql");
        }
    }

    public static CqlSession getSession() {
        return session;
    }

    public static void close() {
        if (session != null) {
            session.close();
        }
    }

    public static void insertDataIntoOrgTimeLinePage(String filePath) {
        for (String statement : CassandraTestUtils.readCQLDumpFile(filePath)) {
            session.execute(statement);
        }
    }
}
