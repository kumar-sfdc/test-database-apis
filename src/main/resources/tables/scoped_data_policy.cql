CREATE TABLE IF NOT EXISTS scoped_data_policy (
    block_all boolean,
    blocked_domains set<text>,
    blocked_emails set<text>,
    id uuid,
    internal_domains set<text>,
    last_modified timestamp,
    policy_info blob,
    scope_id uuid,
    scope_type text,
    video_meeting_blocked_domains set<text>,
    video_meeting_blocked_emails set<text>,
    PRIMARY KEY ((id, scope_id), scope_type)
);