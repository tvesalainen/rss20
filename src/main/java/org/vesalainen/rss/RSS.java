/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author tkv
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rss")
@XmlType(propOrder={"channel"})
public class RSS extends XmlFile
{
    @XmlAttribute
    private String version;
    private List<Channel> channel;

    public RSS()
    {
        channel = new ArrayList<Channel>();
    }

    @Override
    protected void marshall() throws IOException
    {
        for (Channel ch : channel)
        {
            ch.setLastBuildDate(new Date());
        }
        super.marshall();
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public List<Channel> getChannel()
    {
        return channel;
    }

    public void setChannel(List<Channel> channel)
    {
        this.channel = channel;
    }
    public static RSS getInstance(URI uri) throws IOException
    {
        return (RSS) getInstance(uri, RSS.class);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            RSS rss = (RSS) RSS.getInstance(new URI("http://valpuri.org/blog/RSS20.rss"), RSS.class);
            rss.dump();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
