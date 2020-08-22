package io.github.joxebus.test

import io.github.joxebus.beans.Book
import io.github.joxebus.beans.Feed
import io.github.joxebus.service.BlogPostFeedService
import io.github.joxebus.service.BookFeedService
import io.github.joxebus.service.FeedService
import io.github.joxebus.utils.FeedReaderGroovy
import io.github.joxebus.utils.FeedReaderJava
import spock.lang.Shared
import spock.lang.Specification

class FeedReaderSpec extends Specification {

    String bookFeedUrl = "https://www.bookbrowse.com/rss/book_news.rss"
    String blogFeedUrl = "https://groovylopeando.wordpress.com/?feed=rss2"

    @Shared
    FeedService<Book> bookFeedService;
    @Shared
    FeedService<Feed> blogFeedService;

    void setupSpec() {
        bookFeedService = new BookFeedService()
        blogFeedService = new BlogPostFeedService()
    }

    def "FeedReaderGroovy with bookFeedService and can get 10 book records"() {
        given: "a FeedReaderGroovy with bookFeedService"
        FeedReaderGroovy<Book> feedReader = new FeedReaderGroovy<>(bookFeedService)

        when: "feedReader read the bookFeedUrl"
        List<Book> resultList = feedReader.readFeedRecords(bookFeedUrl)

        then: "the number of records returned are 10"
        resultList.size() == 10
    }

    def "FeedReaderJava with bookFeedService and can get 10 book records"() {
        given: "a FeedReaderJava with bookFeedService"
        FeedReaderJava<Book> feedReader = new FeedReaderJava<>(bookFeedService)

        when: "feedReader read the bookFeedUrl"
        List<Book> resultList = feedReader.readFeedRecords(bookFeedUrl)

        then: "the number of records returned are 10"
        resultList.size() == 10
    }

    def "FeedReaderGroovy with blogPostFeedService and can get 10 book records"() {
        given: "a FeedReaderGroovy with blogPostFeedService"
        FeedReaderGroovy<Book> feedReader = new FeedReaderGroovy<>(blogFeedService)

        when: "feedReader read the blogFeedUrl"
        List<Book> resultList = feedReader.readFeedRecords(blogFeedUrl)

        then: "the number of records returned are 10"
        resultList.size() == 10
    }

    def "FeedReaderJava with blogPostFeedService and can get 10 book records"() {
        given: "a FeedReaderJava with blogPostFeedService"
        FeedReaderJava<Book> feedReader = new FeedReaderJava<>(blogFeedService)

        when: "feedReader read the blogFeedUrl"
        List<Book> resultList = feedReader.readFeedRecords(blogFeedUrl)

        then: "the number of records returned are 10"
        resultList.size() == 10

    }

}
