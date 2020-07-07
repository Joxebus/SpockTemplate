package io.github.joxebus.test

import io.github.joxebus.beans.Book

import io.github.joxebus.service.FeedService
import spock.lang.Shared
import spock.lang.Specification

class FeedReaderSpec extends Specification {

    String bookFeed = "https://www.bookbrowse.com/rss/book_news.rss"

    @Shared
    FeedService<Book> bookFeedService;

    def "Test interaction between FeedReaderJava, bookFeedService and blogFeedService"(){

    }

    def "Test interaction between FeedReaderGroovy, bookFeedService and blogFeedService"(){

    }

    def "Test FeedReaderJava return non empty lists of books"(){

    }

    def "Test FeedReaderJava return non empty lists of blogs"(){

    }

    def "Test FeedReaderGroovy return non empty lists of books"(){

    }

    def "Test FeedReaderGroovy return non empty lists of blogs"(){

    }

}
