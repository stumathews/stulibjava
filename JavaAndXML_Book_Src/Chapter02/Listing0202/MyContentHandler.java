import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;


class MyContentHandler extends DefaultHandler
{
   int count=0;


   public void startElement(String uri,
                            String localName,
                            String qualName,
                            Attributes attribs)
   {
      if (qualName.equals("sheep"))
         System.out.println(++count + " sheep");
   }


   public void endDocument()
   {
      System.out.println("Sleep tight!");
   }
}
