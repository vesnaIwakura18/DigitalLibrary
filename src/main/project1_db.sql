create table person (
                        person_id int generated by default as identity primary key,
                        fio varchar(100) not null unique,
                        birth_date int check ( birth_date > 1900 )
);
create table book (
    book_id int generated by default as identity primary key,
    person_id int references person(person_id) on delete set null,
    book_name varchar(100) not null,
    book_author varchar(100) not null,
    book_year_of_production int
);
