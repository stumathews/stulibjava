import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

class MyContentHandler extends DefaultHandler
{
   public void startDocument()
   {
      System.out.println("STARTING");
      System.out.println();
   }


   public void startElement(String uri,
                            String localName,
                            String qualName,
                            Attributes attribs)
   {
      System.out.print("Start tag: ");
      System.out.println(qualName);
   }


   public void endDocument()
   {
      System.out.println();
      System.out.println("ENDING NORMALLY!");
   }
}
