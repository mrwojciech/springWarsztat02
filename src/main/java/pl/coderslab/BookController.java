package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private BooksDao booksDao;

    @Autowired
    public BookController(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    public List<Book> showAllBooks() {
        return booksDao.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(name = "id") Long id) {

        return booksDao.getBookById(id);
    }

    @PostMapping()
    public Book addBook(@RequestBody Book book) {
        booksDao.addBook(book);
        return book;
    }

    @PutMapping()
    public Book updateBook(@RequestBody Book book) {
        booksDao.update(book);
        return book;
    }
    @DeleteMapping()
    public void deletedBook(@RequestParam(name = "id") Long id){
        booksDao.delete(id);

    }

}
