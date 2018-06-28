package com.nearsoft.service;

import com.nearsoft.beans.FeedEntry;

import java.util.List;

public interface FeedService <T> {

    List<T> extractFromFeed(List<FeedEntry> entries);
}
