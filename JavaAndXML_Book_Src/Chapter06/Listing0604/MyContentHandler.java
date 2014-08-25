import org.xml.sax.helpers.DefaultHandler;

class MyContentHandler extends DefaultHandler
{
   public void characters
      (char[] charArray, int start, int length)
   {
      String charString =
         new String(charArray, start, length);

      System.out.println("Sin: " + charString);
   }
}
