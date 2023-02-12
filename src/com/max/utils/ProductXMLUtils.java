package com.max.utils;

import com.max.bean.Cloth;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;

import java.io.*;
import java.util.*;


public class ProductXMLUtils {
    public static List<Cloth> parserProductFormXml(){
        List<Cloth> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3DomDriver());
        xStream.alias("list",products.getClass());
        xStream.allowTypes(new Class[]{products.getClass()});
        xStream.alias("clothes",Cloth.class);
        xStream.allowTypes(new Class[]{Cloth.class});
        xStream.useAttributeFor(Cloth.class,"id");
        try{
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("products.xml"));
            products = (List<Cloth>) xStream.fromXML(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void writeProductToXML(List<Cloth> products){
        XStream xStream = new XStream(new Xpp3DomDriver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Cloth.class);
        xStream.useAttributeFor(Cloth.class,"id");
        try{
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("products.xml"));
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes());
            xStream.toXML(products,outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
