
--drop table if exists PRODUCT;


CREATE TABLE IF NOT EXISTS PRODUCT
(
  SKU_ID          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME        VARCHAR(100) not null,
  DESCRIPTION VARCHAR(255),
  PRICE       BIGINT,
  IMAGE_NAME  VARCHAR(255)
);

CREATE SEQUENCE products_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


CREATE TABLE IF NOT EXISTS MEMBER
(
  MEMBER_ID          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  MEMBER_NAME        VARCHAR(100) not null,
  MEMBER_MOBILE      INTEGER,
  MEMBER_DOB         DATE ,
  MEMBER_GENDER      VARCHAR ,
  MEMBER_ADDRESS     VARCHAR(255),
  DATE_OF_JOINING    DATE ,
  ACTIVE             INTEGER
);


/*CREATE TABLE IF NOT EXISTS `employee` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `email` varchar(50),
    `date_of_birth` timestamp

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;*/

insert into product (name, DESCRIPTION, PRICE, IMAGE_NAME) values
  ('yonex astox', 'Flexible racket', 5000.00, ''),
  ('yonex muscle power', 'medium racket', 2000.00, ''),
  ('Li ing', 'beginner racket', 1000.00, ''),
  ('yonex 303', 'beginner racket', 600.00, ''),
  ('wilson', 'itermediate racket', 3000.00, '');

create table customer (
  id int identity primary key,
  name varchar(255) not null,
  contact_name varchar (255) not null,
  email varchar (255) not null,
  phone varchar (255) not null
);

--drop table if exists CUSTOMER;

insert into customer (name, contact_name, email, phone) values
  ('Coca Cola', 'John Doe', 'john.doe@cocacola.com', '202-555-0143'),
  ('Dell', 'Bob Frapples', 'bob.frapples@dell.com', '202-555-0180'),
  ('Apple', 'Barb Ackue', 'barb.ackue@apple.com', '202-555-0128'),
  ('Google', 'Sue Vaneer', 'sue.vaneer@google.com', '202-555-0174'),
  ('FedEx', 'Robin Banks', 'robin.banks@fedex.com', '202-555-0146'),
  ('Salesforce', 'Zack Lee', 'zack.lee@salesforce.com', '202-555-0122');
