package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/books")
    @ResponseBody
    public List<Book> displayAllBooks() {
        return memoryBookService.getList();
    }

    @RequestMapping("/books/{id}")
    @ResponseBody
    public Book getBook(@PathVariable long id) {
        return memoryBookService.getBookById(id);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(HttpServletRequest request) {
        Book book = new Book();
        book.setAuthor(request.getParameter("author"));
        book.setId(Long.parseLong(request.getParameter("id")));
        book.setIsbn(request.getParameter("isbn"));
        book.setTitle(request.getParameter("title"));
        book.setPublisher(request.getParameter("publisher"));
        book.setType(request.getParameter("type"));

        List<Book> books = memoryBookService.getList();
        books.add(book);
        memoryBookService.setList(books);
        return "Book was added";
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String putBook(HttpServletRequest request, @PathVariable long id) {
        Book book = new Book();
        book.setId(id);
        book.setType(request.getParameter("type"));
        book.setPublisher(request.getParameter("publisher"));
        book.setTitle(request.getParameter("title"));
        book.setIsbn(request.getParameter("isbn"));
        book.setAuthor(request.getParameter("author"));
        memoryBookService.updateBookById(book);

        return "Book was modified.";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBook(HttpServletRequest request, @PathVariable long id) {
        memoryBookService.deleteBookById(id);
        return "Book was deleted.";
    }
}
