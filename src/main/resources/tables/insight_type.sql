CREATE TYPE category AS ENUM ('CUSTOM', 'DEFAULT');

CREATE TABLE insight_type (organization_id CHARACTER(18) NOT NULL,
id UUID NOT NULL,
display_name TEXT NOT NULL,
description_template TEXT NOT NULL,
action_types TEXT[] NOT NULL DEFAULT '{}'::TEXT[],
configuration JSONB[] NOT NULL DEFAULT '{}'::JSONB[],
time_created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT clock_timestamp(),
time_modified TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT clock_timestamp(),
category category NOT NULL DEFAULT 'DEFAULT'::category,
extractor_configuration JSONB NOT NULL DEFAULT '{}'::JSONB,
time_activated TIMESTAMP WITHOUT TIME ZONE,
channel_type TEXT DEFAULT 'EMAIL'::TEXT,
enabled_by TEXT,
source_types TEXT[] NOT NULL DEFAULT '{}'::TEXT[],
sfdc_version DOUBLE PRECISION,
CONSTRAINT insight_type_pkey PRIMARY KEY (organization_id, id)
);