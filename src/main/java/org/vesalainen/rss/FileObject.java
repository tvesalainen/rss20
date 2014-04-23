/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * An object which can be stored in a uri
 * @author tkv
 */
public abstract class FileObject
{
    protected URI uri;
    /**
     * Opens an existing file
     * @param file
     * @throws IOException
     */
    public void open(File file) throws IOException
    {
        this.uri = file.toURI();
        unmarshall();
    }
    public void open(URI uri) throws IOException
    {
        this.uri = uri;
        unmarshall();
    }
    /**
     * Saves content to the same uri that was used when open() or saveAs() was called
     * @throws IOException
     */
    public void save() throws IOException
    {
        if ("file".equals(uri.getScheme()))
        {
            File file = new File(uri);
            boolean exists = file.exists();
            File original = null;
            File backup = null;
            if (exists)
            {
                original = file;
                backup = backup(file);
            }
            try
            {
                marshall();
            }
            catch (Exception ex)
            {
                if (exists)
                {
                    if (!backup.renameTo(original))
                    {
                        throw new IOException(file+" renameTo "+original+" failed", ex);
                    }
                    backup.delete();
                }
                throw new IOException(ex);
            }
            if (exists)
            {
                backup.delete();
            }
        }
        else
        {
            throw new UnsupportedOperationException("save is not supported for "+uri);
        }
    }

    private File backup(File file) throws IOException
    {
        File dir = file.getParentFile();
        File backup = File.createTempFile(file.getName(), ".backup", dir);
        if (!backup.delete())
        {
            throw new IOException(backup+" delete failed");
        }
        if (!file.renameTo(backup))
        {
            throw new IOException(file+" renameTo "+backup+" failed");
        }
        return backup;
    }

    public void delete() throws IOException
    {
        if ("file".equals(uri.getScheme()))
        {
            File file = new File(uri);
            backup(file);
        }
        else
        {
            throw new UnsupportedOperationException("delete is not supported for "+uri);
        }
    }
    /**
     * If uri is not a directory, saves content to a new uri
     * If uri is a directory, saves content to a new uri in that
     * directory. File name is the same as when opening the uri
     * @param uri
     * @throws IOException
     */
    public void saveAs(File fileOrDirectory) throws IOException
    {
        if (fileOrDirectory.isDirectory())
        {
            File nf = new File(fileOrDirectory, uri.getPath());
            uri = nf.toURI();
        }
        else
        {
            uri = fileOrDirectory.toURI();
        }
        save();
    }
    public void saveAs(URI uri) throws IOException
    {
        this.uri = uri;
        save();
    }

    public void setFile(File file)
    {
        uri = file.toURI();
    }

    public void setURI(URI uri)
    {
        this.uri = uri;
    }

    public URI getUri()
    {
        return uri;
    }

    protected abstract void unmarshall() throws IOException;
    protected abstract void marshall() throws IOException;
}
