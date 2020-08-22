package io.github.joxebus.test


import io.github.joxebus.beans.Book
import io.github.joxebus.beans.Feed
import io.github.joxebus.service.FeedService
import spock.lang.Specification

class FeedReaderInteractionSpec extends Specification {

    String bookFeedUrl = "https://www.bookbrowse.com/rss/book_news.rss"
    String blogFeedUrl = "https://groovylopeando.wordpress.com/?feed=rss2"

    FeedService<Book> bookFeedService;
    FeedService<Feed> blogFeedService;

    def "Test interaction between FeedReaderJava and bookFeedService"() {
        given: "FeedReaderJava with a bookFeedService mock"

        when: "readFeedRecords method from feedReader is called"

        then: "extractFromFeed method from feedService should be called 1 time"
    }

    def "Test interaction between FeedReaderJava and blogFeedService"() {
        given: "FeedReaderJava with a blogFeedService mock"

        when: "readFeedRecords method from feedReader is called"

        then: "extractFromFeed method from feedService should be called 1 time"

    }

    def "Test interaction between FeedReaderGroovy bookFeedService"() {
        given: "FeedReaderGroovy with a bookFeedService mock"

        when: "readFeedRecords method from feedReader is called"

        then: "extractFromFeed method from feedService should be called 1 time"
    }

    def "Test interaction between FeedReaderGroovy blogFeedService"() {
        given: "FeedReaderGroovy with a blogFeedService mock"

        when: "readFeedRecords method from feedReader is called"

        then: "extractFromFeed method from feedService should be called 1 time"
    }

}
