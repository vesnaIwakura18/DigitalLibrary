package kz.bisen.springwebapp1.dao;

import kz.bisen.springwebapp1.models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("book_id"));
        book.setName(resultSet.getString("book_name"));
        book.setAuthor(resultSet.getString("book_author"));
        book.setYearOfProduction(resultSet.getString("book_year_of_production"));
        book.setPersonId(resultSet.getInt("person_id"));

        return book;
    }
}
