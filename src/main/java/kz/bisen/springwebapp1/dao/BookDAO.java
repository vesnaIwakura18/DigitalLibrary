package kz.bisen.springwebapp1.dao;

import kz.bisen.springwebapp1.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public List<Book> indexTaken(int id) {
        return jdbcTemplate.query("SELECT * FROM Book where person_id = ?", new BookMapper(), id);
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id}, new BookMapper())
                .stream().findAny().orElse(null);
    }
    public Optional<Book> show(String book_name) {
        return jdbcTemplate.query("SELECT * From Book WHERE book_name = ?", new Object[]{book_name}, new BookMapper())
                .stream().findAny();
    }

    public Optional<Book> showAuthor(String author) {
        return jdbcTemplate.query("SELECT * From Book WHERE book_author = ?", new Object[]{author}, new BookMapper())
                .stream().findAny();
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(book_name, book_author, book_year_of_production) VALUES(?, ?, ?)", book.getName(), book.getAuthor(), Integer.parseInt(book.getYearOfProduction()));
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET book_name=?, book_author=?, book_year_of_production=? WHERE book_id=?", updatedBook.getName(),
                updatedBook.getAuthor(), Integer.parseInt(updatedBook.getYearOfProduction()), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }

    public void select(int personId, int id) {
        jdbcTemplate.update("Update Book SET person_id=? where book_id=?", personId, id);
    }

    public void reject(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=null where book_id=?", id);
    }
}