package com.example.booksshop.controller;

import com.example.booksshop.dao.BookDao;
import com.example.booksshop.entity.Book;
import com.example.booksshop.entity.BookId;
import com.example.booksshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/list-books")
    public String listBooks(Model model){
        model.addAttribute("books",
                bookService.listBooks());
        return "listbooks";
    }

//    book/book-details?id=1&isbn=ISBN-1234

    @GetMapping("/book-details")
    public String bookDetails(@RequestParam("id")int id,
                              @RequestParam("isbn")String isbn,Model model){

        BookId bookId = null;
        if (Objects.nonNull(id) && Objects.nonNull(isbn)){
            bookId = new BookId();
            bookId.setId(id);
            bookId.setIsbn(isbn);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        bookService.findBookById(bookId);
        model.addAttribute("book",bookService.findBookById(bookId));
        return "bookdetails";
    }

}
