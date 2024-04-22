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

-- CREATE TYPE Status AS ENUM('PENDING', 'IN_PROGRESS', 'COMPLETED');
CREATE TABLE if NOT EXISTS tasks
(
    id
    SERIAL
    PRIMARY
    KEY,
    title
    VARCHAR
(
    75
) NOT NULL,
    description VARCHAR
(
    255
),
    due_date DATE NOT NULL,
    status VARCHAR
(
    20
) CHECK
(
    status
    IN
(
    'PENDING',
    'IN_PROGRESS',
    'COMPLETED'
)) NOT NULL,
    created_by INT REFERENCES users
(
    id
),
    updated_by INT REFERENCES users
(
    id
),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   user_id INT REFERENCES users(id),
    version INT NOT NULL
    );
