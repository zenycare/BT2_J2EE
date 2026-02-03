package bai2.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import bai2.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1, "Spring boot", "Cẩm Giang"));
        books.add(new Book(2, "Spring Boot V2", "Phương Anh"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        book.setId(books.size() + 1);
        books.add(book);
    }

    public void updateBook(int id, Book book) {
        Book old = getBookById(id);
        if (old != null) {
            old.setTitle(book.getTitle());
            old.setAuthor(book.getAuthor());
        }
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }
}
