CREATE TABLE Customer(
    userId BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL UNIQUE,
    lastname  VARCHAR(20) NOT NULL UNIQUE ,
    username VARCHAR(40) NOT NULL UNIQUE ,
    email VARCHAR(40) NOT NULL UNIQUE ,
    password VARCHAR(10) NOT NULL
                     CHECK ( LENGTH(password)>=6 )
);
GRANT SELECT, INSERT, UPDATE, DELETE
ON Customer TO postgres;

CREATE TABLE Tour(   tourId BIGSERIAL PRIMARY KEY,
                     title VARCHAR(40) NOT NULL ,
                     description VARCHAR(1000) NOT NULL ,
                     price DECIMAL(12,2) NOT NULL,
GRANT SELECT, INSERT, UPDATE, DELETE
    ON Tour TO postgres;
DROP SEQUENCE seq_tour;
CREATE SEQUENCE seq_tour;
GRANT ALL ON  seq_tour TO postgres;
commit ;

CREATE TABLE Item(
    itemId BIGSERIAL PRIMARY KEY,
    title VARCHAR(40) NOT NULL ,
    description VARCHAR(1000) NOT NULL ,
    price DECIMAL(12,2) NOT NULL,
    tourId BIGSERIAL NOT NULL,
    customer_id BIGSERIAL,
    booked TIMESTAMP(3));
GRANT SELECT, INSERT, UPDATE, DELETE
    ON Item TO postgres;
DROP SEQUENCE seq_item;
CREATE SEQUENCE seq_item;
GRANT ALL ON  seq_item TO postgres;
commit ;
