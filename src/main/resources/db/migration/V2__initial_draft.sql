--CREATE TABLE PRODUCT(
  -- ID INT AUTO_INCREMENT,
  -- NAME VARCHAR(255),
  -- DESCRIPTION VARCHAR(255),
   --PRICE INT,
   --IMAGE_NAME VARCHAR(255)
--);

CREATE TABLE PRODUCT
(
    ID LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NAME VARCHAR2(100) NOT NULL,
    column_3 int,
    DESCRIPTION VARCHAR2(255),
    PRICE BIGINT,
    IMAGE_NAME VARCHAR2(255)
);