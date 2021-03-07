DROP TABLE IF EXISTS ro_person
DROP TABLE IF EXISTS ro_passport

create table ro_person(
    person_id SERIAL,
    first_name varchar(30),
    last_name varchar(30)
    patronymic varchar(30),
    date_birth DATE,
    PRIMARY KEY(id)
)

create table ro_passport(
    passport_id SERIAL,
    passport_seria varchar(10),
    passport_number varchar(10),
    issue_date DATE,
    person_id INTEGER,
    PRIMARY KEY(passport_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE RESTRICT
)