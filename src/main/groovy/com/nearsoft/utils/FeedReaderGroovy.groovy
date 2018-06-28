package com.nearsoft.utils

import com.nearsoft.beans.Blog
import com.nearsoft.beans.Book
import com.nearsoft.beans.Feed
import com.nearsoft.service.FeedService

class FeedReaderGroovy {

    private FeedService<Book> bookFeedService
    private FeedService<Blog> blogFeedService

    FeedReaderGroovy(FeedService<Book> bookFeedService, FeedService<Blog> blogFeedService) {
        this.bookFeedService = bookFeedService
        this.blogFeedService = blogFeedService
    }

    List readBookFeed(String url){
        Feed feed = FeedReaderJava.readFeed(url)
        bookFeedService.extractFromFeed(feed.entries)
    }

    List readBlogFeed(String url){
        Feed feed = FeedReaderJava.readFeed(url)
        blogFeedService.extractFromFeed(feed.entries)

    }

}
