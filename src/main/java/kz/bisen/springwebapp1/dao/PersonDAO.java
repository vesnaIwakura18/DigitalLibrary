package kz.bisen.springwebapp1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import kz.bisen.springwebapp1.models.Person;

import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }
    public Optional<Person> show(String fio) {
        return jdbcTemplate.query("SELECT * From Person WHERE fio = ?", new Object[]{fio}, new PersonMapper())
                .stream().findAny();
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(fio, birth_date) VALUES(?, ?)", person.getFio(), Integer.parseInt(person.getBirthDate()));
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET fio=?, birth_date=? WHERE person_id=?", updatedPerson.getFio(),
                Integer.parseInt(updatedPerson.getBirthDate()), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE person_id=?", id);
    }
}
