import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;

class MyContentHandler extends DefaultHandler
{

   Locator locator;

   public void setDocumentLocator(Locator locator)
   {
      this.locator=locator;
   }

   public void startDocument()
   {
      System.out.println("STARTING");
      showSpecifics();
      System.out.println();
   }


   public void startElement(String uri,
                            String localName,
                            String qualName,
                            Attributes attribs)
   {
      System.out.print("Start tag: ");
      System.out.println(qualName);
      showSpecifics();
      System.out.println();
   }


   public void showSpecifics()
   {
      System.out.println
         ("  Line " + locator.getLineNumber());
      System.out.println
         ("  Column " + locator.getColumnNumber());
      System.out.println
         ("  Document " + locator.getSystemId());
   }

}
