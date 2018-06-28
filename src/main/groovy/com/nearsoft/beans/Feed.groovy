package com.nearsoft.beans

import groovy.transform.Canonical
import groovy.transform.ToString

@Canonical
@ToString(excludes = 'entries')
class Feed {

    String title;
    String author;
    String link;
    String description;
    String pubDate;

    List<FeedEntry> entries = []
}
