package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BooksDao {

    private List<Book> bookList = new ArrayList<>(Arrays.asList(
            new Book(1L, "111-222-333-444", "W pustyni i w puszczy1", "H. Sienkiewicz", "PwN", "powiesc1"),
            new Book(2L, "111-222-333-444", "W pustyni i w puszczy2", "H. Sienkiewicz", "PwN", "powiesc2"),
            new Book(3L, "111-222-333-444", "W pustyni i w puszczy3", "H. Sienkiewicz", "PwN", "powiesc3"),
            new Book(4L, "111-222-333-444", "W pustyni i w puszczy4", "H. Sienkiewicz", "PwN", "powiesc4"),
            new Book(5L, "111-222-333-444", "W pustyni i w puszczy5", "H. Sienkiewicz", "PwN", "powiesc5"),
            new Book(6L, "111-222-333-444", "W pustyni i w puszczy6", "H. Sienkiewicz", "PwN", "powiesc6"),
            new Book(7L, "111-222-333-444", "W pustyni i w puszczy7", "H. Sienkiewicz", "PwN", "powiesc7"),
            new Book(8L, "111-222-333-444", "W pustyni i w puszczy8", "H. Sienkiewicz", "PwN", "powiesc8"),
            new Book(9L, "111-222-333-444", "W pustyni i w puszczy9", "H. Sienkiewicz", "PwN", "powiesc9")
    ));


    public List<Book> getAll() {
        return bookList;
    }

    public Book getBookById(Long id) {
        return bookList.get(id.intValue() - 1);
    }

    public Long addBook(Book book) {
        bookList.add(book);
        return Long.valueOf(bookList.indexOf(book));
    }

    public void update(Book book) {
        bookList.set(getArrayIndexOfBook(book), book);
    }

    private Integer getArrayIndexOfBook(Book book) {
        int indexOf;
        Long id = book.getId();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private int getArrayIndexOfBook(Long id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(Long id) {
        bookList.remove(getArrayIndexOfBook(id));
    }
}
