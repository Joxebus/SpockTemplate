package io.github.joxebus.service;

import io.github.joxebus.beans.Book;
import io.github.joxebus.beans.FeedEntry;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookFeedService implements FeedService<Book> {

    static DateFormat pubDateFormatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");

    public List<Book> extractFromFeed(List<FeedEntry> entries){
        List<Book> bookList = new ArrayList<>();
        for(FeedEntry entry : entries){
            try {
                bookList.add(feedEntryToBook(entry));
            } catch (ParseException e) {
                System.out.printf("The entry doesn't contain a valid date: %s", entry.getPubDate());
            }
        }
        return bookList;
    }

    private static Book feedEntryToBook(FeedEntry entry) throws ParseException {
        Book book = new Book();
        book.setTitle(entry.getTitle());
        book.setLink(entry.getLink());
        book.setPubDate(pubDateFormatter.parse(entry.getPubDate()));
        return book;
    }
}
