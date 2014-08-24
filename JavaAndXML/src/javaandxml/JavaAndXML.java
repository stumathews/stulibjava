/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaandxml;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * General executer
 * @author Stuart
 */
public class JavaAndXML 
{

  /**
   * @param args the command line arguments - first argument is name of the xml file to be parsed
   * @throws org.xml.sax.SAXException
   * @throws javax.xml.parsers.ParserConfigurationException
   * @throws java.io.IOException
   */
  public static void main(String[] args)  throws SAXException, ParserConfigurationException, IOException
  {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    factory.setValidating(true);
    SAXParser saxParser = factory.newSAXParser();
    XMLReader xmlReader = saxParser.getXMLReader();
    xmlReader.setErrorHandler(new MyErrorHandler());
    
    xmlReader.setContentHandler(new MyContentHandler());
    
    try
    {
      xmlReader.parse(new File(args[0]).toURL().toString());      
    }
    catch( SAXException s)
    {
     System.out.println("There's been a big mistake");
     s.printStackTrace();
    }
  }  
}
