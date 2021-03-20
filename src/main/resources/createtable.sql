DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_person;

create table ro_person
(
    sex        INTEGER not null,
    person_id  SERIAL,
    first_name varchar(30) not null,
    last_name  varchar(30) not null,
    patronymic varchar(30),
    date_birth DATE not null,
    PRIMARY KEY (person_id)
);

create table ro_passport
(
    passport_id     SERIAL,
    passport_seria  varchar(10) not null,
    passport_number varchar(10) not null,
    issue_date      DATE not null,
    person_id       INTEGER,
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
);

create table ro_birth_certificate
(
    birth_certificate_id     SERIAL,
    certificate_number varchar(10) not null,
    issue_date      DATE not null,
    person_id       INTEGER,
    father_id       INTEGER,
    mother_id       INTEGER,
    PRIMARY KEY (birth_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
);

INSERT INTO ro_person(sex, first_name, last_name, patronymic, date_birth)
VALUES (1, 'Васильева', 'Елена', 'Петровна', '1997-03-22'),
       (2, 'Васильев', 'Олег', 'Сргеевич', '1996-10-17');