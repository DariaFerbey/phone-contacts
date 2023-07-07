create table PHONE_CONTACTS.USERS
(
    USER_ID      NUMBER(10) not null
        constraint USERS_PK
        primary key,
    USER_NAME    VARCHAR2(50) not null,
    EMAIL        VARCHAR2(50)
);

Insert into PHONE_CONTACTS.USERS (USER_ID, USER_NAME, DISPLAY_NAME, EMAIL)
values (1, 'xxx', 'xxx@xxx.com');
