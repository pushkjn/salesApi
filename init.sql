CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS sales (
    id SERIAL PRIMARY KEY NOT NULL,
    external_id uuid DEFAULT uuid_generate_v4() UNIQUE,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    photos VARCHAR(30) ARRAY[3] NOT NULL
);