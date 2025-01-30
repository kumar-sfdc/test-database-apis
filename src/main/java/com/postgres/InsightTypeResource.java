package com.postgres;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Path("/insighttype")
public class InsightTypeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsightTypes(@QueryParam("organization_id") String organizationId,
                                    @QueryParam("channel_type") String channelType,
                                    @QueryParam("category") String category) {

        System.out.println(organizationId);
        System.out.println(channelType);
        System.out.println(category);

        List<InsightType> insightTypes = new ArrayList<>();

        try {
            Connection connection = PostgresHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM insight_type " +
                    "WHERE organization_id = ? AND channel_type = ? AND category = ?::category");
            preparedStatement.setString(1, organizationId);
            preparedStatement.setString(2, channelType);
            preparedStatement.setString(3, category);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                InsightType insightType = new InsightType();
                insightType.setOrganizationId(rs.getString("organization_id"));
                insightType.setId(UUID.fromString(rs.getString("id")));
                insightType.setDisplayName(rs.getString("display_name"));
                insightType.setDescriptionTemplate(rs.getString("description_template"));
                insightType.setActionTypes(Arrays.asList((String[]) rs.getArray("action_types").getArray()));
                insightType.setConfiguration(Arrays.asList((String[]) rs.getArray("configuration").getArray()));
                insightType.setTimeCreated(rs.getTimestamp("time_created"));
                insightType.setTimeModified(rs.getTimestamp("time_modified"));
                insightType.setCategory(InsightType.Category.valueOf(rs.getString("category")));
                insightType.setExtractorConfiguration(rs.getString("extractor_configuration"));
                insightType.setTimeActivated(rs.getTimestamp("time_activated"));
                insightType.setChannelType(rs.getString("channel_type"));
                insightType.setEnabledBy(rs.getString("enabled_by"));
                insightType.setSourceTypes(Arrays.asList((String[]) rs.getArray("source_types").getArray()));
                insightType.setSfdcVersion(rs.getDouble("sfdc_version"));
                insightTypes.add(insightType);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Response.ok(insightTypes).build();
    }
}
