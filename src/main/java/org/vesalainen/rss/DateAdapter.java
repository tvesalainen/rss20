/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vesalainen.rss;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author tkv
 */
public class DateAdapter extends XmlAdapter<String,Date>
{
    private static final SimpleDateFormat FORMAT_US = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    private static final SimpleDateFormat FORMAT_FI = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
    @Override
    public Date unmarshal(String v) throws Exception
    {
        if (v != null)
        {
            try
            {
                return (Date) FORMAT_US.parse(v);
            }
            catch (ParseException ex)
            {
                return (Date) FORMAT_FI.parse(v);
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public String marshal(Date v) throws Exception
    {
        if (v != null)
        {
            return FORMAT_US.format(v);
        }
        else
        {
            return null;
        }
    }

}
