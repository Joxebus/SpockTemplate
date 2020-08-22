package io.github.joxebus.beans

import groovy.transform.Canonical
import groovy.transform.ToString

@Canonical
@ToString(excludes = 'entries')
class Feed {

    String title;
    String link;
    String description;
    String pubDate;

    List<FeedEntry> entries = []

    void addEntry(FeedEntry entry) {
        entries << entry
    }
}
