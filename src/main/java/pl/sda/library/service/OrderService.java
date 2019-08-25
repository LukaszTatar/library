package pl.sda.library.service;

import org.springframework.stereotype.Service;
import pl.sda.library.model.Book;
import pl.sda.library.repository.BookRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final BookRepository bookRepository;

    public OrderService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Set<Book> findAll(String title) {
        return bookRepository.findAll(title);
    }

    public Optional<Book> rentBook(int id) {
        LocalDate dateOfReturn = LocalDate.now().plusMonths(1);
        return bookRepository.rentBook(id, dateOfReturn);
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public int generateId() {
        return bookRepository.generateId();
    }

    public void removeBook(int id) {
        bookRepository.removeBook(id);
    }
}
