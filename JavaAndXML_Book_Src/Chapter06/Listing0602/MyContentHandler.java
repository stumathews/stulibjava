import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import java.util.Stack;

class MyContentHandler extends DefaultHandler
{
   Stack stack = new Stack();

   public void startElement(String uri,
                            String localName,
                            String qualName,
                            Attributes attribs)
   {
      if (qualName.equals("Mail"))
         stack.push(attribs.getValue("day"));
   }


   public void characters
      (char[] charArray, int start, int length)
   {
      String charString =
         (new String(charArray, start, length).trim());

      if (charString != null && !charString.equals(""))
      {
         System.out.print("Received ");
         System.out.print(stack.peek());
         System.out.print("-\t");
         System.out.println(charString);
      }
   }



   public void endElement(String uri,
                          String localName,
                          String qualName)
   {
      if (qualName.equals("Mail"))
         stack.pop();
   }
}
