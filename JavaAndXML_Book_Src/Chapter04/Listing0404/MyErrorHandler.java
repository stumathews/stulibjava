import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

class MyErrorHandler extends DefaultHandler
{
   public void warning(SAXParseException e)
   {
      System.out.println("Warning:");
      showSpecifics(e);
      System.out.println();
   }

   public void error(SAXParseException e)
   {
      System.out.println("Error:");
      showSpecifics(e);
      System.out.println();
   }

   public void fatalError(SAXParseException e)
   {
      System.out.println("Fatal error:");
      showSpecifics(e);
      System.out.println();
   }

   public void showSpecifics(SAXParseException e)
   {
      System.out.println(e.getMessage());
      System.out.println("  Line " + e.getLineNumber());
      System.out.println("  Column " + e.getColumnNumber());
      System.out.println("  Document " + e.getSystemId());
   }
}
