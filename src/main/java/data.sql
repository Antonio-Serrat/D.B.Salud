
INSERT INTO THERAPISTS (NAME, SPECIALTY, EMAIL, TLF, DNI) VALUES ('Antonio','Develop','antoniodev@gmail.com',2233466, 4455887 );
INSERT INTO AGENDA (THERAPIST_ID) VALUES (1);
INSERT INTO ACCOUNTS (NAME, PASSWORD) VALUES ('root','passroot');
INSERT INTO ACCOUNTS (NAME, PASSWORD, THERAPIST_ID) VALUES ('Antonio','passuser',1);


UPDATE THERAPISTS SET ACCOUNT_ID = 2 where id = 1; 
UPDATE THERAPISTS SET AGENDA_ID = 1  where id = 1;