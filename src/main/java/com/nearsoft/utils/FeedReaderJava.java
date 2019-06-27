package com.nearsoft.utils;

import com.nearsoft.beans.Book;
import com.nearsoft.beans.Feed;
import com.nearsoft.beans.FeedEntry;
import com.nearsoft.service.FeedService;

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
public class FeedReaderJava {

    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String LINK = "link";
    private static final String AUTHOR = "author";
    private static final String ITEM = "item";
    private static final String PUB_DATE = "pubDate";

    private FeedService<Book> bookFeedService;

    public FeedReaderJava(FeedService<Book> bookFeedService) {
        this.bookFeedService = bookFeedService;
    }

    public List<Book> readBookFeed(String feedUrl){
        List<FeedEntry> entries = readFeed(feedUrl).getEntries();
        return bookFeedService.extractFromFeed(entries);
    }

    static Feed readFeed(String feedUrl) {
        Feed feed = null;
        URL url;
        try {
            url = new URL(feedUrl);
            boolean isFeedHeader = true;
            // Set header values intial to the empty string
            String description = null;
            String title = null;
            String link = null;
            String author = null;
            String pubdate = null;

            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = read(url);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName()
                            .getLocalPart();
                    switch (localPart) {
                        case ITEM:
                            if (isFeedHeader) {
                                isFeedHeader = false;
                                feed = new Feed();
                                feed.setTitle(title);
                                feed.setAuthor(author);
                                feed.setLink(link);
                                feed.setPubDate(pubdate);
                                feed.setDescription(description);

                            }
                            event = eventReader.nextEvent();
                            break;
                        case TITLE:
                            title = getCharacterData(event, eventReader);
                            break;
                        case DESCRIPTION:
                            description = getCharacterData(event, eventReader);
                            break;
                        case LINK:
                            link = getCharacterData(event, eventReader);
                            break;
                        case AUTHOR:
                            author = getCharacterData(event, eventReader);
                            break;
                        case PUB_DATE:
                            pubdate = getCharacterData(event, eventReader);
                            break;
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                        FeedEntry feedEntry = new FeedEntry();
                        feedEntry.setTitle(title);
                        feedEntry.setAuthor(author);
                        feedEntry.setLink(link);
                        feedEntry.setPubDate(pubdate);
                        feedEntry.setDescription(description);
                        feed.getEntries().add(feedEntry);
                        continue;
                    }
                }
            }
        } catch (XMLStreamException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    private static String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private static InputStream read(final URL url) {
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
