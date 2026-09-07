--liquibase formatted sql

--changeset goodwoor:1
CREATE TABLE users (
   id          BIGSERIAL PRIMARY KEY,
   first_name  VARCHAR(50) NOT NULL,
   second_name VARCHAR(50) NOT NULL,
   status      VARCHAR(30) NOT NULL
);