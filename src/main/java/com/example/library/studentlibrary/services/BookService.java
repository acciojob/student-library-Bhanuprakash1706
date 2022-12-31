package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Author;
import com.example.library.studentlibrary.models.Book;
import com.example.library.studentlibrary.models.Genre;
import com.example.library.studentlibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    public void createBook(Book book){
        bookRepository2.save(book);
//       Author author= book.getAuthor();
//       int id=author.getId();

        //we need to set author while creating book but here there is no author info
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = null; //find the elements of the list by yourself
        if(genre == null && author == null) books=bookRepository2.findByAvailability(available);
        else if(genre == null) books = bookRepository2.findBooksByAuthor(author,available);
        else if(author == null) books = bookRepository2.findBooksByGenre(genre , available);
        else books = bookRepository2.findBooksByGenreAuthor(genre , author , available);
        return books;
    }
}