CREATE TABLE Customer
(
    userId    BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL,
    lastname  VARCHAR(20) NOT NULL,
    username  VARCHAR(40) NOT NULL,
    email     VARCHAR(40) NOT NULL,
    role    VARCHAR(40) NOT NULL ,
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
CREATE TABLE BookingStatus (bookingStatusId BIGINT NOT NULL, bookingStatus VARCHAR(255), PRIMARY KEY (bookingStatusId));

ALTER TABLE Booking ADD CONSTRAINT fk_Booking_User_ID FOREIGN KEY (customer_id) REFERENCES Customer (userId);
ALTER TABLE Booking ADD CONSTRAINT fk_Booking_bookingPos_id FOREIGN KEY (bookingId) REFERENCES BookingStatus (bookingStatusId, bookingStatus);
ALTER TABLE BookingPos ADD CONSTRAINT fk_bookingPos_tourId FOREIGN KEY (fk_tourId) REFERENCES Tour (tourId);
ALTER TABLE BookingPos ADD CONSTRAINT fk_bookingPos_bookingId FOREIGN KEY (bookingPosId) REFERENCES Booking (bookingId);
CREATE TABLE Sequence (seq_name VARCHAR(50) NOT NULL, seq_count DECIMAL(38), PRIMARY KEY (seq_name));
INSERT INTO Sequence(seq_name, seq_count) values ('seq_gen', 0);

INSERT INTO Customer(userId, firstname, lastname, username, email, password,role) values (1, 'user','1','user1@ffhs.ch','user1@ffhs.ch', '123456', 'ADMIN');
INSERT INTO Customer(userId, firstname, lastname, username, email, password, role) values (2,'user','2','user2@ffhs.ch','user2@ffhs.ch', '123456',  'CUSTOMER');



