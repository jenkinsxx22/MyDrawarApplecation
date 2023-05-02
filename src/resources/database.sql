CREATE TABLE USER_LIST 
(
user_id NUMBER PRIMARY KEY,
first_name VARCHAR2(70),
last_name VARCHAR2(70),
street VARCHAR2(70),
postal_code VARCHAR2(70),
city VARCHAR2(70),
birthdate DATE
);
/
CREATE SEQUENCE USER_LIST_PK_SEQ START WITH 1 INCREMENT BY 1;
CREATE TRIGGER USER_LIST_PK_TRG
BEFORE INSERT ON USER_LIST
FOR EACH ROW
BEGIN
SELECT USER_LIST_PK_SEQ.nextval into :NEW.USER_ID FROM SYS.DUAL;
END;
/