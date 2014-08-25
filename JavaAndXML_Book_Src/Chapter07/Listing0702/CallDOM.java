import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.File;
import org.w3c.dom.Document;


public class CallDOM
{
   public static void main(String args[])
      throws ParserConfigurationException,
             SAXException,
             IOException
   {
      DocumentBuilderFactory factory =
         DocumentBuilderFactory.newInstance();
      DocumentBuilder builder =
         factory.newDocumentBuilder();
      Document doc;


      if (args.length == 1)
      {
         doc = builder.parse
            (new File(args[0]).toURL().toString());
         new MyTreeTraverser (doc);
      }
      else
         System.out.println
            ("Usage: java CallDOM file-name.xml");

   }

}
