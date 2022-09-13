package kz.bisen.springwebapp1.dao;


import org.springframework.jdbc.core.RowMapper;
import kz.bisen.springwebapp1.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("person_id"));
        person.setFio(resultSet.getString("fio"));
        person.setBirthDate(resultSet.getString("birth_date"));
        return person;
    }
}
