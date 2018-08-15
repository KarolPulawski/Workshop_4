package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    void updateBookById(Book book);
    void deleteBookById(Long id);
    List<Book> getList();
}
