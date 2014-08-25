import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

class MyContentHandler extends DefaultHandler
{
   public void startDocument()
   {
      System.out.println("Starting the document.");
   }


   public void startElement(String uri,
                            String localName,
                            String qualName,
                            Attributes attribs)
   {
      System.out.print("Start tag: ");
      System.out.println(qualName);

      for (int i=0; i<attribs.getLength(); i++)
      {
         System.out.print("Attribute: ");
         System.out.print(attribs.getQName(i));
         System.out.print(" = ");
         System.out.println(attribs.getValue(i));
      }
   }


   public void characters
      (char[] charArray, int start, int length)
   {
      String charString =
         new String(charArray, start, length);

      charString = charString.replaceAll("\n", "[cr]");
      charString = charString.replaceAll(" ", "[blank]");

      System.out.print(length + " characters: ");
      System.out.println(charString);
   }


   public void endElement(String uri,
                          String localName,
                          String qualName)
   {
      System.out.print("End tag: ");
      System.out.println(qualName);
   }


   public void endDocument()
   {
      System.out.println("Ending the document.");
   }
}
