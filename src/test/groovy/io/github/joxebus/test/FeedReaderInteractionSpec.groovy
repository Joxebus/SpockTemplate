package io.github.joxebus.test


import io.github.joxebus.service.FeedService
import spock.lang.Specification

class FeedReaderInteractionSpec extends Specification {

    String bookFeedUrl = "https://www.bookbrowse.com/rss/book_news.rss"
    String blogFeedUrl = "https://groovylopeando.wordpress.com/?feed=rss2"

    FeedService feedService

    void setup() {
        feedService = Mock()
    }

    def "Test interaction between FeedReaderJava and feedService"() {
        given: "FeedReaderJava with a feedService mock"

        when: "readFeedRecords method from feedReader is called for both urls"

        then: "extractFromFeed method from feedService should be called 2 times"

    }

    def "Test interaction between FeedReaderGroovy feedService"() {
        given: "FeedReaderGroovy with a feedService mock"

        when: "readFeedRecords method from feedReader is called for both urls"

        then: "extractFromFeed method from feedService should be called 2 times"

    }

}
