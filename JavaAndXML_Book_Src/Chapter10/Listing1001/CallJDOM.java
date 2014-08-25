import org.jdom.JDOMException;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.File;
import java.io.IOException;

public class CallJDOM
{
   public static void main(String args[])
      throws JDOMException,
             IOException
   {
      Document doc;

      SAXBuilder builder = new SAXBuilder(false);

      if (args.length == 1)
      {
         doc = builder.build
            (new File(args[0]).toURL().toString());
         new MyEltTraverser (doc.getRootElement(), 0);
      }
      else
         System.out.println
            ("Usage: java CallDOM file-name.xml");
   }
}
