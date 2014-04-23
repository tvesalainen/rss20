/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@XmlRootElement(name = "channel")
@XmlType(propOrder={
    "title",
    "link",
    "description",
    "language",
    "copyright",
    "managingEditor",
    "webMaster",
    "pubDate",
    "lastBuildDate",
    "generator", 
    "docs",
    "cloud",
    "ttl",
    "image",
    "rating",
    "textInput",
    "item"
})
public class Channel
{
    private String title;
    private URI link;
    private String description;
    private String language;
    private String copyright;
    private String managingEditor;
    private String webMaster;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date pubDate;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date lastBuildDate;
    private String generator;
    private URI docs;
    private Cloud cloud;
    private int ttl;
    private Image image;
    private String rating;
    private TextInput textInput;
    private List<Item> item = new ArrayList<Item>();

    public Channel()
    {
    }

    public Cloud getCloud()
    {
        return cloud;
    }

    public void setCloud(Cloud cloud)
    {
        this.cloud = cloud;
    }

    public String getCopyright()
    {
        return copyright;
    }

    public void setCopyright(String copyright)
    {
        this.copyright = copyright;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public Date getLastBuildDate()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate(Date lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public TextInput getTextInput()
    {
        return textInput;
    }

    public void setTextInput(TextInput textInput)
    {
        this.textInput = textInput;
    }

    public int getTtl()
    {
        return ttl;
    }

    public void setTtl(int ttl)
    {
        this.ttl = ttl;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public URI getDocs()
    {
        return docs;
    }

    public void setDocs(URI docs)
    {
        this.docs = docs;
    }

    public String getGenerator()
    {
        return generator;
    }

    public void setGenerator(String generator)
    {
        this.generator = generator;
    }

    public List<Item> getItem()
    {
        return item;
    }

    public void setItem(List<Item> item)
    {
        this.item = item;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public URI getLink()
    {
        return link;
    }

    public void setLink(URI link)
    {
        this.link = link;
    }

    public String getManagingEditor()
    {
        return managingEditor;
    }

    public void setManagingEditor(String managingEditor)
    {
        this.managingEditor = managingEditor;
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

    public String getWebMaster()
    {
        return webMaster;
    }

    public void setWebMaster(String webMaster)
    {
        this.webMaster = webMaster;
    }
}
