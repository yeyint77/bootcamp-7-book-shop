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
                    "https://mpd-biblio-covers.imgix.net/9781466805309.jpg?w=900"
            );
            Book book2=new Book(
                    2,
                    IsbnGenerator.generate(),
                    "Great Expectations",
                    "Good Choice",
                    25.3,
                    20,
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgUdNz5KQzqGoUvpz-BKjpGyk93QjLguAvsVai5Ah2Wz21hbmXkHowlfvmpnitF8ulNC0&usqp=CAU"
            );
            Book book3=new Book(
                    3,
                    IsbnGenerator.generate(),
                    "Bleak House",
                    "Nice",
                    22.3,
                    20,
                    "https://victorianweb.org/art/illustration/phiz/bleakhouse/41.jpg"
            );
            Book book4=new Book(
                    4,
                    IsbnGenerator.generate(),
                    "Under The Greenwood Tree",
                    "Excellent",
                    50.3,
                    20,
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc9dny5qmkVOSv0DSxR9Mu2dceLk3FW8b-2093-msWUkJ0O9YVbhOE9hu43zy_vcUPMZA&usqp=CAU"

            );
            Book book5=new Book(
                    5,
                    IsbnGenerator.generate(),
                    "Return of the Native",
                    "Excellent",
                    25.3,
                    20,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ034gqJ_RIoQwN6S7pR1jv0c0S6alKoDYurZat6JYOPgFT3NdlPjJ_a7AFjfqoW40wrFc&usqp=CAU"
            );
            Book book6=new Book(
                    6,
                    IsbnGenerator.generate(),
                    "Far From the Maddening Crowd",
                    "Excellent",
                    50.3,
                    20,
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNxgUj4srBLEzX124YFYievvc1ivuAd8CyyHKn49UpgAj3TZQubHrqf7pfDBmiPGp-HjE&usqp=CAU"
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