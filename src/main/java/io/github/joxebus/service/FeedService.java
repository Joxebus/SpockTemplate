package io.github.joxebus.service;

import io.github.joxebus.beans.FeedEntry;

import java.util.List;

public interface FeedService <T> {

    List<T> extractFromFeed(List<FeedEntry> entries);
}
