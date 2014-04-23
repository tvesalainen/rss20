/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author tkv
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Cloud
{
    @XmlAttribute
    private String domain;
    @XmlAttribute
    private int port;
    @XmlAttribute
    private String path;
    @XmlAttribute
    private String registerProcedure;
    @XmlAttribute
    private String protocol;

    public Cloud()
    {
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getProtocol()
    {
        return protocol;
    }

    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }

    public String getRegisterProcedure()
    {
        return registerProcedure;
    }

    public void setRegisterProcedure(String registerProcedure)
    {
        this.registerProcedure = registerProcedure;
    }

}
