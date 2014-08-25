import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException; 


class CallSAX
{
   static public void main(String[] args)
      throws SAXException,
             ParserConfigurationException,
             IOException
   {
      SAXParserFactory factory =
         SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      XMLReader xmlReader = saxParser.getXMLReader();

      xmlReader.setContentHandler(new MyContentHandler());

      xmlReader.parse
         (new File("MyThreeSins.xml").toURL().toString());
   }

}
