package bookLombok.controller;

import bookLombok.repo.BookRepository;
import bookLombok.util.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bookLombok.model.Book;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    Service service;

    @PostMapping("/bookSave")
    public String insertBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Your record is saved successfully";

    }

    @PostMapping("/multipleBookSave")
    public String insertBook(@RequestBody List<Book> book){
        bookRepository.saveAll(book);
        return " record is saved successfully";

    }

    @GetMapping("/getAllBook")
    public List<Book> getBook(){
        return (List<Book>) bookRepository.findAll();

    }

    @GetMapping("/getByBookName/{name}")
    public List<Book> getBook(@PathVariable("name") String bookName){
        return (List<Book>) bookRepository.findBybookName(bookName);

    }

    @GetMapping("/getByBookId/{bookId}")
    public Optional<Book> getBook(@PathVariable("bookId") Long id){
        return  bookRepository.findById(id);
    }

    @DeleteMapping("/DeleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") Long id){
        bookRepository.deleteById(id);
        service.sendMail("2000shraddhapatil@gmail.com","Book","Record Deleted");
        return "Record Deleted Successfully";

    }

    @PutMapping("/updateBook/{bookID}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookID") Long id){
        Book updateBook=bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not exits with id:"+id));
        updateBook.setBookName(book.getBookName());
        updateBook.setBookAuthor(book.getBookAuthor());
        bookRepository.save(updateBook);
        return ResponseEntity.ok(updateBook);

    }


}

