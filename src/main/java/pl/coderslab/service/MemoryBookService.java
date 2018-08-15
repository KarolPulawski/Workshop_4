package pl.coderslab.service;


import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;


@Service
public class MemoryBookService implements BookService{

    private static int counter = 4;

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {return list;}

    public void setList(List<Book> list) {this.list = list;}



    @Override
    public Book getBookById(Long id) {

        for(Book book : list) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void updateBookById(Book book) {
        boolean flag = true;
        for(Book b : list) {
            if(book.getId() == b.getId()) {
                b.setAuthor(book.getAuthor());
                b.setIsbn(book.getIsbn());
                b.setTitle(book.getTitle());
                b.setType(book.getType());
                b.setPublisher(book.getPublisher());
                flag = false;
            }
        }
        if(flag) {
            Book b = new Book();
            b.setId(counter++);
            b.setPublisher(book.getPublisher());
            b.setTitle(book.getTitle());
            b.setIsbn(book.getIsbn());
            b.setAuthor(book.getAuthor());
            b.setType(book.getType());
            list.add(b);
        }
    }

    @Override
    public void deleteBookById(Long id) {
        List<Book> toDelete = new ArrayList<>();
        for(Book book : list) {
            if(book.getId() == id) {
                toDelete.add(book);
            }
        }
        list.removeAll(toDelete);
    }
}
