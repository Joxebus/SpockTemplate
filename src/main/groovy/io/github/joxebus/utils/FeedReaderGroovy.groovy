package io.github.joxebus.utils


import io.github.joxebus.beans.Book
import io.github.joxebus.service.FeedService
import io.github.joxebus.beans.Feed

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
