package io.github.joxebus.test

import io.github.joxebus.beans.Book
import io.github.joxebus.beans.Feed
import io.github.joxebus.service.FeedService
import spock.lang.Specification

class FeedReaderSpec extends Specification {

    String bookFeedUrl = "https://www.bookbrowse.com/rss/book_news.rss"
    String blogFeedUrl = "https://groovylopeando.wordpress.com/?feed=rss2"

    FeedService<Book> bookFeedService;
    FeedService<Feed> blogFeedService;

    def "FeedReaderGroovy with bookFeedService and can get 10 book records"() {
        given: "a FeedReaderGroovy with bookFeedService"

        when: "feedReader read the bookFeedUrl"

        then: "the number of records returned are 10"

    }

    def "FeedReaderJava with bookFeedService and can get 10 book records"() {
        given: "a FeedReaderJava with bookFeedService"

        when: "feedReader read the bookFeedUrl"

        then: "the number of records returned are 10"

    }

    def "FeedReaderGroovy with blogPostFeedService and can get 10 book records"() {
        given: "a FeedReaderGroovy with blogPostFeedService"

        when: "feedReader read the blogFeedUrl"

        then: "the number of records returned are 10"

    }

    def "FeedReaderJava with blogPostFeedService and can get 10 book records"() {
        given: "a FeedReaderJava with blogPostFeedService"

        when: "feedReader read the blogFeedUrl"

        then: "the number of records returned are 10"

    }

}
