package io.github.joxebus.utils

import io.github.joxebus.service.FeedService
import io.github.joxebus.beans.Feed

class FeedReaderGroovy<T> implements FeedReader {

    private FeedService<T> feedService

    FeedReaderGroovy(FeedService<T> feedService) {
        this.feedService = feedService
    }

    List<T> readFeedRecords(String url){
        Feed feed = readFeed(url)
        feedService.extractFromFeed(feed.entries)
    }

}
