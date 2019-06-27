package com.nearsoft.utils


import com.nearsoft.beans.Book
import com.nearsoft.beans.Feed
import com.nearsoft.service.FeedService

class FeedReaderGroovy {

    private FeedService<Book> bookFeedService

    FeedReaderGroovy(FeedService<Book> bookFeedService) {
        this.bookFeedService = bookFeedService
    }

    List readBookFeed(String url){
        Feed feed = FeedReaderJava.readFeed(url)
        bookFeedService.extractFromFeed(feed.entries)
    }

}
