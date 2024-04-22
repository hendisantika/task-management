CREATE TABLE if NOT EXISTS users
(
    id
    SERIAL
    PRIMARY
    KEY,
    email
    VARCHAR
(
    100
) UNIQUE NOT NULL,
    password VARCHAR
(
    50
) NOT NULL,
    first_name VARCHAR
(
    100
) NOT NULL,
    last_name VARCHAR
(
    100
) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version INT NOT NULL
    );
