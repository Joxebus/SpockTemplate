package com.nearsoft.beans;

import java.util.Date;

/**
 * Created by obautista on 3/9/17.
 */
public class Blog {

    private String title;
    private String author;
    private Date pubDate;
    private String link;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pubDate=" + pubDate +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
