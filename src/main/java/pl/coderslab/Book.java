package pl.coderslab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    Long id;
    String isbn;
    String title;
    String author;
    String publisher;
    String type;


}
