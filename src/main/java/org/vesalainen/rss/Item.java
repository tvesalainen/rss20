/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import java.net.URI;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author tkv
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "item")
@XmlType(propOrder={
    "title",
    "link",
    "description",
    "author",
    "category",
    "comments",
    "enclosure",
    "guid",
    "pubDate",
    "source"
})
public class Item implements Comparable<Item>
{
    private String title;
    private URI link;
    private String description;
    private String author;
    private Category category;
    private URI comments;
    private Enclosure enclosure;
    private String guid;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date pubDate = new Date();
    private Source source;

    public Item()
    {
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public URI getComments()
    {
        return comments;
    }

    public void setComments(URI comments)
    {
        this.comments = comments;
    }

    public Enclosure getEnclosure()
    {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure)
    {
        this.enclosure = enclosure;
    }

    public Source getSource()
    {
        return source;
    }

    public void setSource(Source source)
    {
        this.source = source;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getGuid()
    {
        return guid;
    }

    public void setGuid(String guid)
    {
        this.guid = guid;
    }

    public URI getLink()
    {
        return link;
    }

    public void setLink(URI link)
    {
        this.link = link;
    }

    public Date getPubDate()
    {
        return pubDate;
    }

    public void setPubDate(Date pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Override
    public int compareTo(Item o)
    {
        return -pubDate.compareTo(o.pubDate);
    }
}
