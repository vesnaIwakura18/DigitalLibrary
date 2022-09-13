package kz.bisen.springwebapp1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import kz.bisen.springwebapp1.dao.BookDAO;
import kz.bisen.springwebapp1.models.Book;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    private final BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        if (bookDAO.show(book.getName()).isPresent()) {
            errors.rejectValue("name", "", "Эта книга уже есть в базе данных");
        } else if (bookDAO.show(book.getAuthor()).isPresent()) {
            errors.rejectValue("author", "", "Имя автора уже есть в базе данных");
        }
    }
}
