/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import java.net.URI;
import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author tkv
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"url", "title", "link"})
public class Image
{
    private URL url;
    private String title;
    private URI link;

    public Image()
    {
    }

    public URI getLink()
    {
        return link;
    }

    public void setLink(URI link)
    {
        this.link = link;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public URL getUrl()
    {
        return url;
    }

    public void setUrl(URL url)
    {
        this.url = url;
    }
    
}
