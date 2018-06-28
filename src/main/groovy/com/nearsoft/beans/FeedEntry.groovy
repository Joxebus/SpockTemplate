package com.nearsoft.beans

import groovy.transform.Canonical
import groovy.transform.ToString

@Canonical
@ToString(excludes = ['link', 'description'])
class FeedEntry {
    String title;
    String author;
    String link;
    String description;
    String pubDate;
}
