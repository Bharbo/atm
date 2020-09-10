CREATE TABLE IF NOT EXISTS USERS
(
    id        INT          NOT NULL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS ACCOUNTS
(
    id             INT          NOT NULL PRIMARY KEY,
    number         VARCHAR(255) NOT NULL,
    balance        VARCHAR(255) NOT NULL,
    account_type   VARCHAR(255) NOT NULL,
    account_status VARCHAR(255) NOT NULL,
    card_number    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS BANKS
(
    id          INT          NOT NULL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    location    VARCHAR(255) NOT NULL,
    corr_number VARCHAR(255) NOT NULL,
    bik         VARCHAR(255) NOT NULL,
    kpp         VARCHAR(255) NOT NULL,
    inn         VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS CARDS
(
    id             INT          NOT NULL PRIMARY KEY,
    number         VARCHAR(255) NOT NULL,
    validThrough   VARCHAR(255) NOT NULL,
    cvc            VARCHAR(255) NOT NULL,
    pass           VARCHAR(255) NOT NULL,
    privilegeType  VARCHAR(255) NOT NULL,
    payment_system VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS OPERATIONS
(
    id      INT          NOT NULL PRIMARY KEY,
    number  VARCHAR(255) NOT NULL,
    op_type VARCHAR(255) NOT NULL,
    date    VARCHAR(255) NOT NULL
);