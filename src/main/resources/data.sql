create table CONTACTS
(
    CONTACT_ID          NUMBER(10) not null,
    NAME     VARCHAR2(10),
    PASSWORD VARCHAR2(50),
    ENABLED           CHAR default 'Y'
);
insert into CONTACTS (CONTACT_ID, NAME, PASSWORD)
values (1, xxx, '$2a$10$Z6YLkAEilxielQZcMb311uFufEjkYFyzoaBhYCvoyd/kczLQC7x7e');