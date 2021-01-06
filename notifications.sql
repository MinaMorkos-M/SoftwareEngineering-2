CREATE TABLE templates (
  id VARCHAR(50) ,
  subject VARCHAR(45) NOT NULL,
  content VARCHAR(45) NOT NULL,
  language VARCHAR(45) NOT NULL,
  primary key (id)
);


CREATE TABLE sms (
  id VARCHAR(50) ,
  subject VARCHAR(45) NOT NULL,
  content VARCHAR(45) NOT NULL,
  language VARCHAR(45) NOT NULL,
  primary key (id)
);


CREATE TABLE mail (
  id VARCHAR(50) ,
  subject VARCHAR(45) NOT NULL,
  content VARCHAR(45) NOT NULL,
  language VARCHAR(45) NOT NULL,
  primary key (id)
);

INSERT INTO templates(id , subject , content , language)VALUES('e9daf10c-10cb-4ec4-aac9-464993472c1c', 'mina', 'morkos', 'ENGLISH');
INSERT INTO templates(id , subject , content , language)VALUES('0892d944-6bf2-4970-875d-9385a1795fe4', 'philo', 'morkos', 'ENGLISH');
INSERT INTO templates(id , subject , content , language)VALUES('1927f37e-c02d-4774-a502-493631fc263a', 'fady', 'morkos', 'ENGLISH');


SELECT * FROM templates;
SELECT * FROM sms;
SELECT * FROM mail;

DROP TABLE templates;
DROP TABLE sms;
DROP TABLE mail;