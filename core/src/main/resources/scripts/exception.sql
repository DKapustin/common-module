CREATE TABLE IF NOT EXSITS exception (
    uuid BIGINT PRIMARY KEY NOT NULL,
    system_type_id VARCHAR(255) NOT NULL,
    method_params  TEXT NOT NULL
    );