import org.jdom.JDOMException;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.File;

/* Copout: Lots of exceptions checked with the lame
           'throws Exception' clause. Exceptions that
           can be thrown by this code include:
           ClassNotFoundException, InstantiationException,
           NoSuchMethodException, IllegalAccessException,
           InvocationTargetException.
*/

public class CallJDOM
{
   public static void main(String args[]) throws Exception
   {
      Document doc;

      SAXBuilder builder = new SAXBuilder(false);

      if (args.length == 1)
      {
         doc = builder.build
            (new File(args[0]).toURL().toString());
         new FrameMaker (doc);
      }
      else
         System.out.println
            ("Usage: java CallDOM file-name.xml");
   }
}
