package com.example;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public class EciVideosPolicy {

    private UUID id;
    private UUID scopeId;
    private String scopeType;
    private Boolean blockAll;
    private Instant lastModified;
    private ByteBuffer policyInfo;
    private Set<String> blockedDomains;
    private Set<String> videoMeetingBlockedDomains;
    private Set<String> blockedEmails;
    private Set<String> videoMeetingBlockedEmails;

    public EciVideosPolicy(UUID id, UUID scopeId, String scopeType, Boolean blockAll, Instant lastModified) {
        this.id = id;
        this.scopeId = scopeId;
        this.scopeType = scopeType;
        this.blockAll = blockAll;
        this.lastModified = lastModified;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getScopeId() {
        return scopeId;
    }

    public void setScopeId(UUID scopeId) {
        this.scopeId = scopeId;
    }

    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public Boolean isBlockAll() {
        return blockAll;
    }

    public void setBlockAll(Boolean blockAll) {
        this.blockAll = blockAll;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public ByteBuffer getPolicyInfo() {
        return policyInfo;
    }

    public void setPolicyInfo(ByteBuffer policyInfo) {
        this.policyInfo = policyInfo;
    }

    public Set<String> getBlockedDomains() {
        return blockedDomains;
    }

    public void setBlockedDomains(Set<String> blockedDomains) {
        this.blockedDomains = blockedDomains;
    }

    public Set<String> getVideoMeetingBlockedDomains() {
        return videoMeetingBlockedDomains;
    }

    public void setVideoMeetingBlockedDomains(Set<String> videoMeetingBlockedDomains) {
        this.videoMeetingBlockedDomains = videoMeetingBlockedDomains;
    }

    public Set<String> getBlockedEmails() {
        return blockedEmails;
    }

    public void setBlockedEmails(Set<String> blockedEmails) {
        this.blockedEmails = blockedEmails;
    }

    public Set<String> getVideoMeetingBlockedEmails() {
        return videoMeetingBlockedEmails;
    }

    public void setVideoMeetingBlockedEmails(Set<String> videoMeetingBlockedEmails) {
        this.videoMeetingBlockedEmails = videoMeetingBlockedEmails;
    }

    // Optional: Override toString() for easier logging and debugging
    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", scopeId=" + scopeId +
                ", scopeType='" + scopeType + '\'' +
                ", blockAll=" + blockAll +
                ", lastModified=" + lastModified +
                ", policyInfo=" + (policyInfo != null ? "[BLOB]" : "null") +
                ", blockedDomains=" + blockedDomains +
                ", videoMeetingBlockedDomains=" + videoMeetingBlockedDomains +
                ", blockedEmails=" + blockedEmails +
                ", videoMeetingBlockedEmails=" + videoMeetingBlockedEmails +
                '}';
    }
}

