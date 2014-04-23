/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author tkv
 */
public class XmlFile extends FileObject
{
    private JAXBContext ctx;

    protected XmlFile()
    {
        try
        {
            ctx = JAXBContext.newInstance(getClass());
        }
        catch (JAXBException ex)
        {
            throw new IllegalArgumentException(ex);
        }
    }

    public static XmlFile getInstance(URI uri, Class cls) throws IOException
    {
        try
        {
            JAXBContext ctx = JAXBContext.newInstance(cls);
            Unmarshaller um = ctx.createUnmarshaller();
            XmlFile xf = (XmlFile) um.unmarshal(uri.toURL());
            xf.unmarshall();
            xf.uri = uri;
            xf.ctx = ctx;
            return xf;
        }
        catch (IllegalArgumentException ex)
        {
            throw new IOException(ex);
        }
        catch (JAXBException ex)
        {
            throw new IOException(ex);
        }
    }

    public static XmlFile getInstance(File file, Class cls) throws IOException
    {
        try
        {
            JAXBContext ctx = JAXBContext.newInstance(cls);
            Unmarshaller um = ctx.createUnmarshaller();
            XmlFile xf = (XmlFile) um.unmarshal(file);
            xf.unmarshall();
            xf.uri = file.toURI();
            xf.ctx = ctx;
            return xf;
        }
        catch (IllegalArgumentException ex)
        {
            throw new IOException(ex);
        }
        catch (JAXBException ex)
        {
            throw new IOException(ex);
        }
    }

    @Override
    protected void marshall() throws IOException
    {
        try
        {
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File(uri);
            FileOutputStream fos = new FileOutputStream(file);
            m.marshal(this, fos);
            fos.close();
        }
        catch (JAXBException ex)
        {
            throw new IOException(ex);
        }
    }

    public void marshall(Writer writer) throws IOException
    {
        try
        {
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(this, writer);
        }
        catch (JAXBException ex)
        {
            throw new IOException(ex);
        }
    }

    public void dump() throws JAXBException
    {
        Marshaller m = ctx.createMarshaller();
        //m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(this, System.err);
    }

    @Override
    protected void unmarshall() throws IOException
    {
        // TO DO Add additional initializations
    }
}
