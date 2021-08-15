package com.books.booklist.domain;

//import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "books")
public class Books {
    @Id private String id;
    
    private String title;
    private String author;
    private Boolean unread;
    private String description;
    //private Date createdAt;

    public Books() {

    }

    public Books(String title, String author, Boolean unread, String description) {
        //this._id = _id;
        this.title = title;
        this.author = author;
        this.unread = unread;
        this.description = description;
        //this.createdAt = createdAt;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public Boolean isUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //public Date createdAt() {
    //    return this.createdAt;
    //}

    //public void setCreatedAt(Date createdAt) {
    //    this.createdAt = createdAt;
    //}
}