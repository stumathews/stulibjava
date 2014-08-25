import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

class MyContentHandler extends DefaultHandler
{

   public void characters
      (char[] charArray, int start, int length)
   {
      System.out.print("CHARACTERS: ");
      myWriteString(charArray, start, length);
   }


   public void ignorableWhitespace
      (char[] charArray, int start, int length)
   {
      System.out.print("IGNORABLE WHITESPACE: ");
      myWriteString(charArray, start, length);
   }


   void myWriteString
      (char[] charArray, int start, int length)
   {
      String charString =
         new String(charArray, start, length);

      charString = charString.replaceAll("\n", "[cr]");
      charString = charString.replaceAll(" ", "[blank]");

      System.out.print(length + " characters: "); 
      System.out.println(charString);
   }
}
