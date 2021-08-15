package com.books.booklist.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.books.booklist.domain.Books;

public interface BooksList extends MongoRepository<Books, String> {
    
	List<Books> findAll();
	
    List<Books> findByTitleContaining(String title);
    
    
    List<Books> findBookById(String id);

    //List<Books> findByAuthor(String author);

    List<Books> findByUnread(Boolean unread);

    //List<Books> findByDescription(String description);
    
    //Books getBooksById(String id);
    //@SuppressWarnings("unchecked")
	//@Override
    //Books insert(Books books);
    //void updateBooks(String id, Books books);
    //void deleteBooks(String booksId);
}