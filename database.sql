-- CREATING CUSTOMERS TABLE 
create table customers(customer_id varchar2(20) constraint pk_customer_id primary key , customer_name varchar2(50), customer_email varchar(50) unique, password varchar2(50) not null, phone_number varchar2(20), address varchar2(50), date_of_registration date default sysdate                         
);

CREATE SEQUENCE customers_id_seq;

CREATE OR REPLACE TRIGGER cust_tgr
    BEFORE INSERT
    ON customers
    FOR EACH ROW
BEGIN
    IF :NEW.customer_id IS NULL THEN
        SELECT 'C'||TRIM(TO_CHAR(customers_id_seq.NEXTVAL,'0000000')) INTO :NEW.customer_id FROM DUAL;
    END IF;
END;



----- CREATING CATEGORY TABLE
create table categories(category_id number, category_name varchar2(50) unique);

DROP TABLE CATEGORIES CASCADE CONSTRAINTS;
DROP SEQUENCE category_id_seq;
CREATE SEQUENCE category_id_seq MINVALUE 1 INCREMENT BY 1 START WITH 1;
DROP TRIGGER car_tgr;
CREATE OR REPLACE TRIGGER hr.cat_tgr
    BEFORE INSERT
    ON hr.categories
    FOR EACH ROW
BEGIN
    IF INSERTING THEN
    IF :NEW.category_id IS NULL THEN
        SELECT category_id_seq.NEXTVAL INTO :NEW.category_id FROM DUAL;
    END IF;
    END IF;
END;

----- CREATING PRODUCTS TABLE

create table products(product_id number constraint pk_product_id primary key , product_name varchar2(50), category_id number not null , product_price number(12,2), product_image varchar2(20), product_available_qty varchar2(50),
                        constraint fk_category foreign key (category_id) references categories(category_id)
);


CREATE SEQUENCE product_id_seq MINVALUE 1 INCREMENT BY 1 START WITH 1;

CREATE OR REPLACE TRIGGER prod_tgr
    BEFORE INSERT
    ON products
    FOR EACH ROW
BEGIN
    IF :NEW.product_id IS NULL THEN
        SELECT 'P'||TO_CHAR(product_id_seq.NEXTVAL,'0000000') INTO :NEW.product_id FROM DUAL;
    END IF;
END;