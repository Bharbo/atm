CREATE TABLE IF NOT EXISTS USERS
(
    id          INT          NOT NULL PRIMARY KEY,
    firstname   VARCHAR(255) NOT NULL,
    lastname    VARCHAR(255) NOT NULL,
    role        VARCHAR(255) NOT NULL,
);
