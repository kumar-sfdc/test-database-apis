package com.example;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/emails")
public class OrgTimeLinePageResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmails() {
        List<Email> emails = new ArrayList<>();
        ResultSet rs = CassandraHelper.getSession().execute("SELECT id, page, time, type, hash, subject FROM orgtimelinepage");
        for (Row row : rs) {
            emails.add(new Email(row.getUuid("id"), row.getInstant("page"), row.getInstant("time"),
                    row.getString("type"), row.getString("hash"), row.getString("subject")));
        }
        return Response.ok(emails).build();
    }
}