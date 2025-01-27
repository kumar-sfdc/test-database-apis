package com.example;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Email {

    private UUID id;
    private Instant page;
    private Instant time;
    private String type;
    private String hash;

    private Map<String, ByteBuffer> cherryPicks;
    private Set<String> contributingUrns;

    private Map<String, Instant> crmAssociationDisassociated;
    private Map<String, Instant> crmAssociationManualCore;
    private Map<String, Instant> crmAssociationManualCrawler;
    private Map<String, String> crmAssociationParticipants;
    private Map<String, Instant> crmAssociationSmart;

    private Map<UUID, ByteBuffer> edits;

    private String engagementCadenceStepTrackerId;
    private String engagementEmailTemplateId;
    private Instant engagementLastTimeOpened;
    private String engagementSfdcEmailEntityId;
    private String engagementToken;

    private ByteBuffer event;

    private Set<String> externalResources;

    private Map<UUID, ByteBuffer> follows;

    private Boolean hasChildren;

    private Set<String> insightKeys;
    private Set<String> insightTypeKeys;
    private Set<String> involvedUrns;

    private Map<String, ByteBuffer> legacyAutoShares;
    private Map<String, ByteBuffer> legacyCherryPicks;

    private Map<UUID, ByteBuffer> likes;

    private Set<String> momentKeys;

    private Instant parentDate;
    private String parentKey;

    private Map<String, Map<String, Double>> participantTalkListenRatio;

    private Map<String, String> props;

    private String sfdcActivityId;
    private ByteBuffer sfdcEvent;

    private String subject;
    private String unifiedId;


    public Email(UUID id, Instant page, Instant time, String type, String hash, String subject) {
        this.id = id;
        this.page = page;
        this.time = time;
        this.type = type;
        this.hash = hash;
        this.subject = subject;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getPage() {
        return page;
    }

    public void setPage(Instant page) {
        this.page = page;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Map<String, ByteBuffer> getCherryPicks() {
        return cherryPicks;
    }

    public void setCherryPicks(Map<String, ByteBuffer> cherryPicks) {
        this.cherryPicks = cherryPicks;
    }

    public Set<String> getContributingUrns() {
        return contributingUrns;
    }

    public void setContributingUrns(Set<String> contributingUrns) {
        this.contributingUrns = contributingUrns;
    }

    public Map<String, Instant> getCrmAssociationDisassociated() {
        return crmAssociationDisassociated;
    }

    public void setCrmAssociationDisassociated(Map<String, Instant> crmAssociationDisassociated) {
        this.crmAssociationDisassociated = crmAssociationDisassociated;
    }

    public Map<String, Instant> getCrmAssociationManualCore() {
        return crmAssociationManualCore;
    }

    public void setCrmAssociationManualCore(Map<String, Instant> crmAssociationManualCore) {
        this.crmAssociationManualCore = crmAssociationManualCore;
    }

    public Map<String, Instant> getCrmAssociationManualCrawler() {
        return crmAssociationManualCrawler;
    }

    public void setCrmAssociationManualCrawler(Map<String, Instant> crmAssociationManualCrawler) {
        this.crmAssociationManualCrawler = crmAssociationManualCrawler;
    }

    public Map<String, String> getCrmAssociationParticipants() {
        return crmAssociationParticipants;
    }

    public void setCrmAssociationParticipants(Map<String, String> crmAssociationParticipants) {
        this.crmAssociationParticipants = crmAssociationParticipants;
    }

    public Map<String, Instant> getCrmAssociationSmart() {
        return crmAssociationSmart;
    }

    public void setCrmAssociationSmart(Map<String, Instant> crmAssociationSmart) {
        this.crmAssociationSmart = crmAssociationSmart;
    }

    public Map<UUID, ByteBuffer> getEdits() {
        return edits;
    }

    public void setEdits(Map<UUID, ByteBuffer> edits) {
        this.edits = edits;
    }

    public String getEngagementCadenceStepTrackerId() {
        return engagementCadenceStepTrackerId;
    }

    public void setEngagementCadenceStepTrackerId(String engagementCadenceStepTrackerId) {
        this.engagementCadenceStepTrackerId = engagementCadenceStepTrackerId;
    }

    public String getEngagementEmailTemplateId() {
        return engagementEmailTemplateId;
    }

    public void setEngagementEmailTemplateId(String engagementEmailTemplateId) {
        this.engagementEmailTemplateId = engagementEmailTemplateId;
    }

    public Instant getEngagementLastTimeOpened() {
        return engagementLastTimeOpened;
    }

    public void setEngagementLastTimeOpened(Instant engagementLastTimeOpened) {
        this.engagementLastTimeOpened = engagementLastTimeOpened;
    }

    public String getEngagementSfdcEmailEntityId() {
        return engagementSfdcEmailEntityId;
    }

    public void setEngagementSfdcEmailEntityId(String engagementSfdcEmailEntityId) {
        this.engagementSfdcEmailEntityId = engagementSfdcEmailEntityId;
    }

    public String getEngagementToken() {
        return engagementToken;
    }

    public void setEngagementToken(String engagementToken) {
        this.engagementToken = engagementToken;
    }

    public ByteBuffer getEvent() {
        return event;
    }

    public void setEvent(ByteBuffer event) {
        this.event = event;
    }

    public Set<String> getExternalResources() {
        return externalResources;
    }

    public void setExternalResources(Set<String> externalResources) {
        this.externalResources = externalResources;
    }

    public Map<UUID, ByteBuffer> getFollows() {
        return follows;
    }

    public void setFollows(Map<UUID, ByteBuffer> follows) {
        this.follows = follows;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Set<String> getInsightKeys() {
        return insightKeys;
    }

    public void setInsightKeys(Set<String> insightKeys) {
        this.insightKeys = insightKeys;
    }

    public Set<String> getInsightTypeKeys() {
        return insightTypeKeys;
    }

    public void setInsightTypeKeys(Set<String> insightTypeKeys) {
        this.insightTypeKeys = insightTypeKeys;
    }

    public Set<String> getInvolvedUrns() {
        return involvedUrns;
    }

    public void setInvolvedUrns(Set<String> involvedUrns) {
        this.involvedUrns = involvedUrns;
    }

    public Map<String, ByteBuffer> getLegacyAutoShares() {
        return legacyAutoShares;
    }

    public void setLegacyAutoShares(Map<String, ByteBuffer> legacyAutoShares) {
        this.legacyAutoShares = legacyAutoShares;
    }

    public Map<String, ByteBuffer> getLegacyCherryPicks() {
        return legacyCherryPicks;
    }

    public void setLegacyCherryPicks(Map<String, ByteBuffer> legacyCherryPicks) {
        this.legacyCherryPicks = legacyCherryPicks;
    }

    public Map<UUID, ByteBuffer> getLikes() {
        return likes;
    }

    public void setLikes(Map<UUID, ByteBuffer> likes) {
        this.likes = likes;
    }

    public Set<String> getMomentKeys() {
        return momentKeys;
    }

    public void setMomentKeys(Set<String> momentKeys) {
        this.momentKeys = momentKeys;
    }

    public Instant getParentDate() {
        return parentDate;
    }

    public void setParentDate(Instant parentDate) {
        this.parentDate = parentDate;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public Map<String, Map<String, Double>> getParticipantTalkListenRatio() {
        return participantTalkListenRatio;
    }

    public void setParticipantTalkListenRatio(Map<String, Map<String, Double>> participantTalkListenRatio) {
        this.participantTalkListenRatio = participantTalkListenRatio;
    }

    public Map<String, String> getProps() {
        return props;
    }

    public void setProps(Map<String, String> props) {
        this.props = props;
    }

    public String getSfdcActivityId() {
        return sfdcActivityId;
    }

    public void setSfdcActivityId(String sfdcActivityId) {
        this.sfdcActivityId = sfdcActivityId;
    }

    public ByteBuffer getSfdcEvent() {
        return sfdcEvent;
    }

    public void setSfdcEvent(ByteBuffer sfdcEvent) {
        this.sfdcEvent = sfdcEvent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUnifiedId() {
        return unifiedId;
    }

    public void setUnifiedId(String unifiedId) {
        this.unifiedId = unifiedId;
    }
}
