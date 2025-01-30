package com.example;

import com.datastax.oss.driver.api.core.cql.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/ecivideospolicy")
public class ScopedDataPolicyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEciVideosPolicy (@QueryParam("id") UUID id,
                               @QueryParam("scope_id") UUID scopeId) {

        System.out.println(id);
        System.out.println(scopeId);

        List<EciVideosPolicy> eciVideosPolicyList = new ArrayList<>();
        SimpleStatement simpleStatement
                = SimpleStatement.builder("SELECT * FROM scoped_data_policy WHERE id = ? AND scope_id = ?")
                .build();
        PreparedStatement preparedStatement = CassandraHelper.getSession().prepare(simpleStatement);
        BoundStatement boundStatement = preparedStatement.bind(id, scopeId);
        ResultSet rs = CassandraHelper.getSession().execute(boundStatement);
        for (Row row : rs) {
            eciVideosPolicyList.add(new EciVideosPolicy(row.getUuid("id"), row.getUuid("scope_id"),
                    row.getString("scope_type"),
                    row.getBoolean("block_all"),
                    row.getInstant("last_modified")));
        }
        return Response.ok(eciVideosPolicyList).build();
    }
}

// http://localhost:8080/api/ecivideospolicy?id=67773189-5b17-3671-0b0d-789f00000000&scope_id=67773189-5b17-3671-0b0d-789f00000000