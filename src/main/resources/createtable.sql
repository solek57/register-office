DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_person;

create table ro_person
(
    sex        INTEGER     not null,
    person_id  SERIAL,
    first_name varchar(30) not null,
    last_name  varchar(30) not null,
    patronymic varchar(30),
    date_birth DATE        not null,
    PRIMARY KEY (person_id)
);

create table ro_passport
(
    passport_id     SERIAL,
    passport_seria  varchar(10) not null,
    passport_number varchar(10) not null,
    issue_date      DATE        not null,
    person_id       INTEGER,
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
);

create table ro_birth_certificate
(
    birth_certificate_id SERIAL,
    certificate_number   varchar(10) not null,
    issue_date           DATE        not null,
    person_id            INTEGER,
    father_id            INTEGER,
    mother_id            INTEGER,
    PRIMARY KEY (birth_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
);

create table ro_marriage_certificate
(
    marriage_certificate_id     SERIAL,
    marriage_certificate_number varchar(10) not null,
    issue_date                  DATE        not null,
    end_date                    DATE        not null,
    active                      BOOLEAN,
    husband_id                  INTEGER,
    wife_id                     INTEGER,
    person_id                   INTEGER,
    PRIMARY KEY (marriage_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (husband_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (wife_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
);

INSERT INTO ro_person(sex, first_name, last_name, patronymic, date_birth)
VALUES (1, 'Елена', 'Васильева', 'Петровна', '1997-03-22'),
       (2, 'Олег', 'Васильев', 'Сргеевич', '1996-10-17'),
       (2, 'Сергей', 'Васильев', 'Олегович', '2018-03-21');

INSERT INTO ro_passport(person_id, passport_seria, passport_number, issue_date)
VALUES (1, '40000', '123456', '2018-04-10')

INSERT INTO ro_birth_certificate(person_id, father_id, mother_id, certificate_number, issue_date)
VALUES (3, 1, 2, '123456', '2018-04-01')
