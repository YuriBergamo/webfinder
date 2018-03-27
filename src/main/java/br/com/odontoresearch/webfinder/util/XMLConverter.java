package br.com.odontoresearch.webfinder.util;

import com.thoughtworks.xstream.XStream;

import java.util.Map;

public class XMLConverter {

    public static Map getMapFromXml(String xml){
        try {
            XStream xStream = new XStream();
            xStream.alias("map", java.util.Map.class);
            return (Map)xStream.fromXML(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
