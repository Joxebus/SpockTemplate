package com.nearsoft.beans;

import java.util.Date;

public class Book {

    private String title;
    private String author;
    private Date pubDate;
    private String link;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null)
            return false;
        if (author != null ? !author.equals(book.author) : book.author != null)
            return false;
        if (pubDate != null ? !pubDate.equals(book.pubDate) : book.pubDate != null)
            return false;
        return link != null ? link.equals(book.link) : book.link == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pubDate=" + pubDate +
                ", link='" + link + '\'' +
                '}';
    }
}
