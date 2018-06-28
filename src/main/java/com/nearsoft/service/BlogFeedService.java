package com.nearsoft.service;

import com.nearsoft.beans.Blog;
import com.nearsoft.beans.FeedEntry;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BlogFeedService implements FeedService<Blog> {

    static DateFormat pubDateFormatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");

    public List<Blog> extractFromFeed(List<FeedEntry> entries){
        List<Blog> blogList = new ArrayList<>();
        for(FeedEntry entry : entries){
            try {
                blogList.add(feedEntryToBlog(entry));
            } catch (ParseException e) {
                System.out.printf("The entry doesn't contain a valid date: %s", entry.getPubDate());
            }
        }
        return blogList;
    }

    private static Blog feedEntryToBlog(FeedEntry entry) throws ParseException {
        Blog blog = new Blog();
        blog.setTitle(entry.getTitle());
        blog.setAuthor(entry.getAuthor());
        blog.setLink(entry.getLink());
        blog.setDescription(entry.getDescription());
        blog.setPubDate(pubDateFormatter.parse(entry.getPubDate()));
        return blog;
    }
}
