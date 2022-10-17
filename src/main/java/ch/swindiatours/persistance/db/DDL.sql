DROP TABLE items;
DROP Table customer;

CREATE TABLE customer(
    id INTEGER(19) PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL UNIQUE,
    lastname  VARCHAR(20) NOT NULL UNIQUE ,
    username VARCHAR(40) NOT NULL UNIQUE ,
    email VARCHAR(40) NOT NULL UNIQUE ,
    password VARCHAR(10) NOT NULL
                     CHECK ( LENGTH(password)>=6 )
);
GRANT SELECT, INSERT, UPDATE, DELETE
ON customer TO postgres;

CREATE TABLE item(
    id INTEGER(19) PRIMARY KEY,
    title VARCHAR(40) NOT NULL ,
    description VARCHAR(1000) NOT NULL ,
    price DECIMAL(12,2) NOT NULL,
    photo BLOB,
    tour_id INTEGER(19) NOT NULL,
    customer_id INTEGER(19),
    booked TIMESTAMP(3),
    CONSTRAINT fk_tour_id
                 FOREIGN KEY (tour_id)REFERENCES  customer (id),
    CONSTRAINT fk_customer
                 FOREIGN KEY (customer_id);
GRANT SELECT, INSERT, UPDATE, DELETE
    ON item TO postgres;
DROP SEQUENCE seq_customer;
CREATE SEQUENCE seq_customer;
GRANT ALL ON  seq_customer TO swindiatours_user;

DROP SEQUENCE  seq_item;
CREATE SEQUENCE seq_item;
GRANT ALL ON seq_item TO postgres;

    commit ;
)