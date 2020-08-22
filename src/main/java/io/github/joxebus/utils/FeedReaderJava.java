package io.github.joxebus.utils;

import io.github.joxebus.beans.BlogPost;
import io.github.joxebus.beans.Book;
import io.github.joxebus.beans.Feed;
import io.github.joxebus.beans.FeedEntry;
import io.github.joxebus.service.FeedService;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * This class is an example of Java Mixin with groovy.
 */
public class FeedReaderJava<T> implements FeedReader {

    private FeedService<T> feedService;

    public FeedReaderJava(FeedService<T> feedService) {
        this.feedService = feedService;
    }

    public List<T> readFeedRecords(String feedUrl){
        List<FeedEntry> entries = readFeed(feedUrl).getEntries();
        return feedService.extractFromFeed(entries);
    }

}
