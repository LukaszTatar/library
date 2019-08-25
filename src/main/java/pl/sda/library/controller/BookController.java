package pl.sda.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.library.model.Book;
import pl.sda.library.service.OrderService;

import java.security.PublicKey;
import java.util.Optional;
import java.util.Set;

@RestController
public class BookController {

    private final OrderService orderService;

    public BookController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/books", produces = "application/json")
    public Set<Book> returnSet(@RequestParam(required = false) String title) {
        return orderService.findAll(title);
    }


    @GetMapping(value = "/book/order/{id}", produces = "application/json")
    public ResponseEntity<Book> rentBook(@PathVariable int id) {
        Optional<Book> book = orderService.rentBook(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/book/add", consumes = "application/json")
    public ResponseEntity addBook(@RequestBody Book book) {
        orderService.addBook(book);
        Book addedBook = book;
        addedBook.setId(orderService.generateId());
        return new ResponseEntity<>(addedBook.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("book/remove/{id}")
    public void removeBook(@PathVariable int id) {
        orderService.removeBook(id);
    }

}
