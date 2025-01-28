package com.example;

import com.datastax.oss.driver.api.core.cql.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/emails")
public class OrgTimeLinePageResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmails (@QueryParam("id") UUID id,
                               @QueryParam("page") String page,
                               @QueryParam("time") String time,
                               @QueryParam("type") String type,
                               @QueryParam("hash") String hash) {

        System.out.println(id);
        System.out.println(page);
        System.out.println(time);
        System.out.println(type);
        System.out.println(hash);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSZ");
        ZonedDateTime zonedDateTimePage = ZonedDateTime.parse(page, formatter);
        ZonedDateTime zonedDateTimeTime = ZonedDateTime.parse(time, formatter);
        Instant pageTime = zonedDateTimePage.toInstant();
        Instant eventTime = zonedDateTimeTime.toInstant();

        List<Email> emails = new ArrayList<>();
        SimpleStatement simpleStatement
                = SimpleStatement.builder("SELECT * FROM orgtimelinepage WHERE id = ? AND page = ? " +
                        "AND time = ? AND type = ? AND hash = ? LIMIT 1")
                .build();
        PreparedStatement preparedStatement = CassandraHelper.getSession().prepare(simpleStatement);
        BoundStatement boundStatement = preparedStatement.bind(id, pageTime, eventTime, type, hash);
        ResultSet rs = CassandraHelper.getSession().execute(boundStatement);
        for (Row row : rs) {
            emails.add(new Email(row.getUuid("id"), row.getInstant("page"), row.getInstant("time"),
                    row.getString("type"), row.getString("hash"), row.getString("subject")));
        }
        return Response.ok(emails).build();
    }
}

// http://localhost:8080/api/emails?id=6546adec-f7cd-aa6a-3ffb-466200000000&page=2024-11-01%2000%3A00%3A00.000000%2B0000&time=2024-11-30%2023%3A06%3A28.000000%2B0000&type=EMAIL&hash=5c64cee2edc56a9a161ce4bf9c2408f4