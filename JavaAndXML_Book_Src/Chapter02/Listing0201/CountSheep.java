import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;


class CountSheep
{
   static public void main(String[] args) throws Exception
   {
      SAXParserFactory factory =
         SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      XMLReader xmlReader = saxParser.getXMLReader();

      xmlReader.setContentHandler(new MyContentHandler());

      xmlReader.parse
         (new File("Sheep.xml").toURL().toString());
   }
}
