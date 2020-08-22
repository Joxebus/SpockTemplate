package io.github.joxebus.test

import io.github.joxebus.service.FeedService
import io.github.joxebus.utils.FeedReaderGroovy
import io.github.joxebus.utils.FeedReaderJava
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
        FeedReaderJava feedReader = new FeedReaderJava(feedService)

        when: "readFeedRecords method from feedReader is called for both urls"
        feedReader.readFeedRecords(bookFeedUrl)
        feedReader.readFeedRecords(blogFeedUrl)

        then: "extractFromFeed method from feedService should be called 2 times"
        2 * feedService.extractFromFeed(_)
    }

    def "Test interaction between FeedReaderGroovy feedService"() {
        given: "FeedReaderGroovy with a feedService mock"
        FeedReaderGroovy feedReader = new FeedReaderGroovy(feedService)

        when: "readFeedRecords method from feedReader is called for both urls"
        feedReader.readFeedRecords(bookFeedUrl)
        feedReader.readFeedRecords(blogFeedUrl)

        then: "extractFromFeed method from feedService should be called 2 times"
        2 * feedService.extractFromFeed(_)
    }

}
