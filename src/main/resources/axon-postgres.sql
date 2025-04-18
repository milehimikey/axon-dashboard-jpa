-- Axon Framework PostgreSQL Schema

-- Domain Event Entry table - stores the actual events
CREATE TABLE IF NOT EXISTS domain_event_entry (
    global_index         BIGSERIAL    PRIMARY KEY,
    aggregate_identifier VARCHAR(255) NOT NULL,
    sequence_number      BIGINT       NOT NULL,
    type                 VARCHAR(255),
    event_identifier     VARCHAR(255) NOT NULL,
    meta_data            BYTEA,
    payload              BYTEA        NOT NULL,
    payload_revision     VARCHAR(255),
    payload_type         VARCHAR(255) NOT NULL,
    time_stamp           VARCHAR(255) NOT NULL,
    UNIQUE (aggregate_identifier, sequence_number),
    UNIQUE (event_identifier)
    );

-- Snapshot Event Entry table - stores snapshots of aggregates
CREATE TABLE IF NOT EXISTS snapshot_event_entry (
    aggregate_identifier VARCHAR(255) NOT NULL,
    sequence_number      BIGINT       NOT NULL,
    type                 VARCHAR(255) NOT NULL,
    event_identifier     VARCHAR(255) NOT NULL,
    meta_data            BYTEA,
    payload              BYTEA        NOT NULL,
    payload_revision     VARCHAR(255),
    payload_type         VARCHAR(255) NOT NULL,
    time_stamp           VARCHAR(255) NOT NULL,
    PRIMARY KEY (aggregate_identifier, sequence_number),
    UNIQUE (event_identifier)
    );

-- Saga Entry table - stores saga instances
CREATE TABLE IF NOT EXISTS saga_entry (
    saga_id         VARCHAR(255) NOT NULL,
    revision        VARCHAR(255),
    saga_type       VARCHAR(255),
    serialized_saga BYTEA,
    PRIMARY KEY (saga_id)
    );

-- Association Value Entry table - stores associations between sagas and domain objects
CREATE TABLE IF NOT EXISTS association_value_entry (
    id                BIGSERIAL    PRIMARY KEY,
    association_key   VARCHAR(255) NOT NULL,
    association_value VARCHAR(255),
    saga_id           VARCHAR(255) NOT NULL,
    saga_type         VARCHAR(255),
    UNIQUE (saga_id, association_key, association_value)
    );

-- Token Entry table - stores tracking tokens for event processors
CREATE TABLE IF NOT EXISTS token_entry (
    processor_name VARCHAR(255) NOT NULL,
    segment        INTEGER      NOT NULL,
    token          BYTEA,
    token_type     VARCHAR(255),
    timestamp      VARCHAR(255),
    owner          VARCHAR(255),
    PRIMARY KEY (processor_name, segment)
    );

-- Dead Letter Entry table - stores events that could not be processed
CREATE TABLE IF NOT EXISTS dead_letter_entry (
    dead_letter_id      VARCHAR(255) NOT NULL PRIMARY KEY,
    queue_id            VARCHAR(255) NOT NULL,
    sequence_identifier  BIGINT       NOT NULL,
    sequence_index      BIGINT       NOT NULL,
    message_type        VARCHAR(255) NOT NULL,
    message_id          VARCHAR(255) NOT NULL,
    cause_message       VARCHAR(255),
    cause_type          VARCHAR(255),
    diagnostics         BYTEA,
    enqueued_at         TIMESTAMP    NOT NULL,
    last_touched        TIMESTAMP    NOT NULL,
    processing_started  TIMESTAMP,
    processing_group    VARCHAR(255) NOT NULL,
    UNIQUE (queue_id, sequence_identifier, sequence_index)
    );
