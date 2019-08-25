package pl.sda.library.repository;

import org.springframework.stereotype.Repository;
import pl.sda.library.model.Book;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private Set<Book> books = initializeBooks();

    private Set<Book> initializeBooks() {
        Book book1 = new Book(1, "King", "Pan Mercedes", null);
        Book book2 = new Book(2, "Harari", "Homo Deus", null);
        Book book3 = new Book(3, "Hawking", "Black holes", null);
        Book book4 = new Book(4, "King", "To", null);
        Book book5 = new Book(5, "King", "Reka mistrza", null);
        return new HashSet<>(Arrays.asList(book1, book2, book3, book4, book5));
    }

    public Set<Book> findAll(String title) {
        if (title == null) {
            return books;
        } else
            return books.stream()
                    .filter(book1 -> book1.getTitle().equals(title))
                    .collect(Collectors.toSet());
    }

    public Optional<Book> rentBook(int id, LocalDate dateOfReturn) {
                Optional<Book> foundBook = books.stream()
                .filter(book -> book.getId()==id)
                .findAny();
                foundBook.ifPresent(book -> book.setDateOfReturn(dateOfReturn));
        return foundBook;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int generateId() {
        return books.size()+1;
    }

    public void removeBook(int id) {
        books.stream().filter(book -> book.getId() == id).findAny().ifPresent(book -> books.remove(book));
    }
}
