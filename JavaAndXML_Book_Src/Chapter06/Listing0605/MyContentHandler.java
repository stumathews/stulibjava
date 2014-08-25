import org.xml.sax.helpers.DefaultHandler;
import java.util.StringTokenizer;


class MyContentHandler extends DefaultHandler
{
   public void characters
      (char[] charArray, int start, int length)
   {
      String charString =
         new String(charArray, start, length);

      StringTokenizer tokenizer =
         new StringTokenizer(charString, "\n");

      while (tokenizer.hasMoreTokens())
      {
         String token = tokenizer.nextToken().trim();
         if (token != null && !token.equals(""))
            System.out.println("Sin: " + token);
      }

   }
}
