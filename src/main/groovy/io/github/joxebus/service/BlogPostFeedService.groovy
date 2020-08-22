package io.github.joxebus.service

import io.github.joxebus.beans.BlogPost
import io.github.joxebus.beans.FeedEntry

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

class BlogPostFeedService implements FeedService<BlogPost> {

    static DateFormat pubDateFormatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz")

    List<BlogPost> extractFromFeed(List<FeedEntry> entries){
        List<BlogPost> blogPostList = []
        entries.each { entry ->
            try {
                blogPostList.add(feedEntryToBlogPost(entry))
            } catch (ParseException e) {
                printf("The entry doesn't contain a valid date: %s", entry.getPubDate());
            }
        }
        blogPostList
    }

    private static BlogPost feedEntryToBlogPost(FeedEntry entry) throws ParseException {
        BlogPost blogPost = new BlogPost()
        blogPost.with {
            title = entry.title
            link = entry.link
            pubDate = pubDateFormatter.parse(entry.pubDate)
        }
        blogPost
    }
}
