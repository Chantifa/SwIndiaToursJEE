CREATE TABLE Customer
(
    userId    BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL UNIQUE,
    lastname  VARCHAR(20) NOT NULL UNIQUE,
    username  VARCHAR(40) NOT NULL UNIQUE,
    email     VARCHAR(40) NOT NULL UNIQUE,
    password  VARCHAR(10) NOT NULL
        CHECK ( LENGTH(password) >= 6 )
);
GRANT SELECT, INSERT, UPDATE, DELETE
ON Customer TO postgres;

CREATE TABLE Tour(   tourId BIGSERIAL PRIMARY KEY,
                     title VARCHAR(40) NOT NULL ,
                     description VARCHAR(1000) NOT NULL ,
                     price DECIMAL(12,2) NOT NULL);
GRANT SELECT, INSERT, UPDATE, DELETE
    ON Tour TO postgres;
DROP SEQUENCE seq_tour;
CREATE SEQUENCE seq_tour;
GRANT ALL ON  seq_tour TO postgres;
commit ;

CREATE TABLE Booking(
    bookingId BIGSERIAL PRIMARY KEY,
    title VARCHAR(40) NOT NULL ,
    description VARCHAR(1000) NOT NULL ,
    price DECIMAL(12,2) NOT NULL,
    tourId BIGSERIAL NOT NULL,
    tourDate DATE,
    customer_id BIGSERIAL NOT NULL ,
    bookedAtDate TIMESTAMP(3) NOT NULL);
GRANT SELECT, INSERT, UPDATE, DELETE
    ON Booking TO postgres;
DROP SEQUENCE seq_booking;
CREATE SEQUENCE seq_booking;
GRANT ALL ON  seq_booking TO postgres;
commit ;

CREATE TABLE BookingPos(
                        bookingPosId BIGSERIAL PRIMARY KEY,
                        fk_bookingId BIGSERIAL NOT NULL ,
                        fk_tourId BIGSERIAL NOT NULL,
                        description VARCHAR(1000) NOT NULL ,
                        price DECIMAL(12,2) NOT NULL,
                        fk_customer_id BIGSERIAL NOT NULL ,
                        bookedDate TIMESTAMP(3));
GRANT SELECT, INSERT, UPDATE, DELETE
    ON Booking TO postgres;
DROP SEQUENCE seq_pos;
CREATE SEQUENCE seq_pos;
GRANT ALL ON  seq_pos TO postgres;
commit ;