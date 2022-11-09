CREATE TABLE IF NOT EXSITS debug (
                                     uuid BIGINT PRIMARY KEY NOT NULL,
                                     system_type_id BIGINT NOT NULL,
                                     method_params  TEXT NOT NULL
);
CREATE TABLE IF NOT EXSITS exception (
                                         uuid BIGINT PRIMARY KEY NOT NULL,
                                         system_type_id BIGINT NOT NULL,
                                         method_params  TEXT NOT NULL
);