package io.github.joxebus.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import io.github.joxebus.beans.Feed;
import io.github.joxebus.beans.FeedEntry;

public interface FeedReader {

    String TITLE = "title";
    String DESCRIPTION = "description";
    String LINK = "link";
    String AUTHOR = "author";
    String ITEM = "item";
    String PUB_DATE = "pubDate";

    default Feed readFeed(String feedUrl) {
        Feed feed = null;
        URL url;
        try {
            url = new URL(feedUrl);
            boolean isFeedHeader = true;
            // Set header values intial to the empty string
            String description = null;
            String title = null;
            String link = null;
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
                                feed.setLink(link);
                                feed.setPubDate(pubdate);
                                feed.setDescription(description);
                            }
                            event = eventReader.nextEvent();

                            // clear title
                            title = null;
                            break;
                        case TITLE:
                            if(Objects.isNull(title)) { // Only the first title is valid
                                title = getCharacterData(event, eventReader);
                            }
                            break;
                        case DESCRIPTION:
                            description = getCharacterData(event, eventReader);
                            break;
                        case LINK:
                            link = getCharacterData(event, eventReader);
                            break;
                        case PUB_DATE:
                            pubdate = getCharacterData(event, eventReader);
                            break;
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equalsIgnoreCase(ITEM)) {
                        FeedEntry feedEntry = new FeedEntry();
                        feedEntry.setTitle(title);
                        feedEntry.setLink(link);
                        feedEntry.setPubDate(pubdate);
                        feedEntry.setDescription(description);
                        feed.addEntry(feedEntry);
                    }
                }
            }
        } catch (XMLStreamException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    default String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    default InputStream read(final URL url) {
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
