package com.postgres;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class InsightType {

    private String organizationId;
    private UUID id;
    private String displayName;
    private String descriptionTemplate;
    private List<String> actionTypes;
    private List<String> configuration;
    private Timestamp timeCreated;
    private Timestamp timeModified;
    private Category category;
    private String extractorConfiguration;
    private Timestamp timeActivated;
    private String channelType;
    private String enabledBy;
    private List<String> sourceTypes;
    private Double sfdcVersion;

    public enum Category {
        CUSTOM, DEFAULT
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescriptionTemplate() {
        return descriptionTemplate;
    }

    public void setDescriptionTemplate(String descriptionTemplate) {
        this.descriptionTemplate = descriptionTemplate;
    }

    public List<String> getActionTypes() {
        return actionTypes;
    }

    public void setActionTypes(List<String> actionTypes) {
        this.actionTypes = actionTypes;
    }

    public List<String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List<String> configuration) {
        this.configuration = configuration;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Timestamp timeModified) {
        this.timeModified = timeModified;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getExtractorConfiguration() {
        return extractorConfiguration;
    }

    public void setExtractorConfiguration(String extractorConfiguration) {
        this.extractorConfiguration = extractorConfiguration;
    }

    public Timestamp getTimeActivated() {
        return timeActivated;
    }

    public void setTimeActivated(Timestamp timeActivated) {
        this.timeActivated = timeActivated;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getEnabledBy() {
        return enabledBy;
    }

    public void setEnabledBy(String enabledBy) {
        this.enabledBy = enabledBy;
    }

    public List<String> getSourceTypes() {
        return sourceTypes;
    }

    public void setSourceTypes(List<String> sourceTypes) {
        this.sourceTypes = sourceTypes;
    }

    public Double getSfdcVersion() {
        return sfdcVersion;
    }

    public void setSfdcVersion(Double sfdcVersion) {
        this.sfdcVersion = sfdcVersion;
    }
}
