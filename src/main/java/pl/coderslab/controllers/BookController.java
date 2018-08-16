package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.TransferService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService memoryBookService;

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

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        memoryBookService.updateBookById(book);
        return "Book was added";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateBook(@RequestBody Book book, @PathVariable long id) {
        memoryBookService.updateBookById(book);
        return "Book was modified";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBook(HttpServletRequest request, @PathVariable long id) {
        memoryBookService.deleteBookById(id);
        return "Book was deleted.";
    }
}
