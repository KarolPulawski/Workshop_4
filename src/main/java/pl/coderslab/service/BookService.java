package pl.coderslab.service;

import pl.coderslab.model.Book;

public interface BookService {
    Book getBookById(Long id);
    void updateBookById(Book book);
    void deleteBookById(Long id);
}
