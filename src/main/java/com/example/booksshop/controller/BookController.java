package com.example.booksshop.controller;

import com.example.booksshop.dao.BookDao;
import com.example.booksshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

//    public String listBooks(Model model){
//        model.addAttribute("books",
//                bookService.listBooks());
//
//        return "/";
//    }

}
