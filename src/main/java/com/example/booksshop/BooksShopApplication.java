package com.example.booksshop;

import com.example.booksshop.dao.AuthorDao;
import com.example.booksshop.dao.BookDao;
import com.example.booksshop.dao.GenreDao;
import com.example.booksshop.dao.PublisherDao;
import com.example.booksshop.entity.Author;
import com.example.booksshop.entity.Book;
import com.example.booksshop.entity.Genre;
import com.example.booksshop.entity.Publisher;
import com.example.booksshop.util.IsbnGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BooksShopApplication {
    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final PublisherDao publisherDao;
    @Bean @Transactional
    @Profile("data")
    public ApplicationRunner runner(){
        return  r ->{
            Author author1=
                    new Author("Charles Dickens","charles@gmail.com");
            Author author2=
                    new Author("Thomas Hardy","hardy@gmail.com");

            Publisher publisher1=new Publisher("New Era","newera@gmail.com");
            Publisher publisher2=new Publisher("Sun","sun@gmail.com");

            Genre genre1=new Genre();
            genre1.setGenreName("Tragedy");

            Genre genre2=new Genre();
            genre2.setGenreName("Adventure");
//public Book(int id, String isbn, String title, String description, double price, int stock,String imgUrl) {
            Book book1=new Book(
                    1,
                    IsbnGenerator.generate(),
                    "Oliver Twist",
                    "Excellent",
                    50.3,
                    20,
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FW%2FMEDIAX_792452-T2%2Fimages%2FI%2F51zYFogJw3L.jpg&tbnid=0y9uQuMlrcHyiM&vet=12ahUKEwiCw-bTptKDAxU-pWMGHffTCNoQMygAegQIARBt..i&imgrefurl=https%3A%2F%2Fwww.amazon.com%2FOliver-Twist-Illustrated-Annotated-Collection-ebook%2Fdp%2FB006L0RI58&docid=h95HPi6bjyxgVM&w=315&h=500&q=oliver%20twist%20book&ved=2ahUKEwiCw-bTptKDAxU-pWMGHffTCNoQMygAegQIARBt"
            );
            Book book2=new Book(
                    2,
                    IsbnGenerator.generate(),
                    "Great Expectations",
                    "Good Choice",
                    25.3,
                    20,
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fcdn2.penguin.com.au%2Fcovers%2Foriginal%2F9780451531186.jpg&tbnid=NVe2jTtIyoRzFM&vet=12ahUKEwjw9-ryptKDAxWav2MGHb3JDXAQMygDegQIARBg..i&imgrefurl=https%3A%2F%2Fwww.penguin.co.nz%2Fbooks%2Fgreat-expectations-9780451531186&docid=ZZo14X00E4Y_yM&w=1253&h=2062&q=Great%20Expectations%20cover&ved=2ahUKEwjw9-ryptKDAxWav2MGHb3JDXAQMygDegQIARBg"
            );
            Book book3=new Book(
                    3,
                    IsbnGenerator.generate(),
                    "Bleak House",
                    "Nice",
                    22.3,
                    20,
                    "https://source.unsplash.com/400x300/?ocean"
            );
            Book book4=new Book(
                    4,
                    IsbnGenerator.generate(),
                    "Under The Greenwood Tree",
                    "Excellent",
                    50.3,
                    20,
                    "https://source.unsplash.com/400x300/?sunset"
            );
            Book book5=new Book(
                    5,
                    IsbnGenerator.generate(),
                    "Return of the Native",
                    "Excellent",
                    25.3,
                    20,
                    "https://source.unsplash.com/400x300/?beach"
            );
            Book book6=new Book(
                    6,
                    IsbnGenerator.generate(),
                    "Far From the Maddening Crowd",
                    "Excellent",
                    50.3,
                    20,
                    "https://source.unsplash.com/400x300/?ocean"
            );
            //mapping
            author1.addBook(book1);
            author1.addBook(book2);
            author1.addBook(book3);

            author2.addBook(book4);
            author2.addBook(book5);
            author2.addBook(book6);


            Publisher pub1=publisherDao.save(publisher1);

            pub1.addBook(book1);
            pub1.addBook(book2);
            pub1.addBook(book3);

            Publisher pub2=publisherDao.save(publisher2);

            pub2.addBook(book4);
            pub2.addBook(book5);
            pub2.addBook(book6);

            Genre gen1=genreDao.save(genre1);
            Genre gen2=genreDao.save(genre2);

            book1.addGenres(gen1);
            book2.addGenres(gen1);
            book3.addGenres(gen1);

            book4.addGenres(gen2);
            book5.addGenres(gen2);
            book6.addGenres(gen2);

//            bookDao.save(book1);
//            bookDao.save(book2);
//            bookDao.save(book3);
//            bookDao.save(book4);
//            bookDao.save(book5);
//            bookDao.save(book6);
            authorDao.save(author1);
            authorDao.save(author2);




        };
    }


    public static void main(String[] args) {
        SpringApplication.run(BooksShopApplication.class, args);
    }

}