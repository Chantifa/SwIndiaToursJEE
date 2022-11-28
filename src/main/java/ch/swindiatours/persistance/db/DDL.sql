CREATE TABLE IF NOT EXISTS Customer
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

CREATE TABLE IF NOT EXISTS Tour(  tourId BIGSERIAL PRIMARY KEY,
                    title VARCHAR(40) NOT NULL ,
                    description VARCHAR(1000) NOT NULL ,
                    price DECIMAL(12,2) NOT NULL,
                    img BYTEA);
GRANT SELECT, INSERT, UPDATE, DELETE
    ON Tour TO postgres;
DROP SEQUENCE seq_tour;
CREATE SEQUENCE seq_tour;
GRANT ALL ON  seq_tour TO postgres;
commit ;


CREATE TABLE IF NOT EXISTS Booking(
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

CREATE TABLE IF NOT EXISTS BookingPos(
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

CREATE TABLE IF NOT EXISTS BookingStatus (bookingStatusId BIGINT NOT NULL, bookingStatus VARCHAR(255), PRIMARY KEY (bookingStatusId));

ALTER TABLE Booking ADD CONSTRAINT fk_Booking_User_ID FOREIGN KEY (customer_id) REFERENCES Customer (userId);
ALTER TABLE Booking ADD CONSTRAINT fk_Booking_bookingPos_id FOREIGN KEY (bookingId) REFERENCES BookingStatus (bookingStatusId, bookingStatus);
ALTER TABLE BookingPos ADD CONSTRAINT fk_bookingPos_tourId FOREIGN KEY (fk_tourId) REFERENCES Tour (tourId);
ALTER TABLE BookingPos ADD CONSTRAINT fk_bookingPos_bookingId FOREIGN KEY (bookingPosId) REFERENCES Booking (bookingId);
DROP TABLE Sequence;
CREATE TABLE IF NOT EXISTS Sequence (seq_name VARCHAR(50) NOT NULL, seq_count DECIMAL(38), PRIMARY KEY (seq_name));
INSERT INTO Sequence(seq_name, seq_count) values ('seq_gen', 0);

INSERT INTO Customer(userId, firstname, lastname, username, email, password, role) values (1, 'user1','user1','user1@ffhs.ch','user1@ffhs.ch', '123456', 'ADMIN');
INSERT INTO Customer(userId, firstname, lastname, username, email, password, role) values (2,'user2','user2','user2@ffhs.ch','user2@ffhs.ch', '123456', 'CUSTOMER');

INSERT INTO Tour (tourId, title, description, price, img)  values (1,'Agra','An immense mausoleum of white marble, built in Agra between 1631 and 1648 by order of the Mughal emperor Shah Jahan in memory of his favourite wife, the Taj Mahal
                    is the jewel of Muslim art in India and one of the universally admired masterpieces of the worlds heritage. With driver from new Delhi to Agra with one over night at a 4 star hotel',250.00, 'src/main/webapp/resources/img/agra.png' );

INSERT INTO Tour (tourId, title, description, price, img)  values (2,'Delhi','New Delhi a city of 18 mio people. Humayun Tomb, Red Fort, JamaMajid, Akshardham, Qutb Minaar, Lotus Temple, Rashtrapati Bhavan, India Gate, and many more, for 4 days at a  star hotel',  650,
                'src/main/webapp/resources/img/delhi.png' );
INSERT INTO Tour (tourId, title, description, price, img)  values (3,'Amritsar','Amritsar historically also known as Rāmdāspur and colloquially as Ambarsar,
                    is a city in northwestern India which is the administrative headquarters of the Amritsar district and is located in the Majha region of the Indian state of Punjab. The city with the Golden Temple',  300.00,
                                                                   'src/main/webapp/resources/img/golden_temple.png' );
INSERT INTO Tour (tourId, title, description, price, img)  values (4,'airport drop and pick up','if you have any package tour booked with us, Airport pick up and drop is free',  30.00,
                                                                   'src/main/webapp/resources/img/golden_temple.png' );
INSERT INTO Tour (tourId, title, description, price, img)  values (5,'Rajasthan','Jaipur, Udaipur, Pushkar, Jodhpur, Jaisalmer, Bikaner, two weeks inclusive driver and camel ridding in the desert, 4 star hotels',2000,
                                                                   'src/main/webapp/resources/img/udaipur.png' );
INSERT INTO Tour (tourId, title, description, price, img)  values (6,'Rishikesh and Haridwar','Haridwar An important and religious city of Hindu at the Ganges river and Rishikesh World yoga and meditation center river rafting in Ganges river, with driver and 4 days at a 4 star hotel',
                                                                   350.00, 'src/main/webapp/resources/img/udaipur.png' );
