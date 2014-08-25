import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import java.io.IOException;
import java.util.Iterator;


public class MyDisplayer
{
   MyMessageHelper helper = new MyMessageHelper();


   void displayOnConsole (SOAPMessage message)
      throws SOAPException, IOException
   {
      message.writeTo(System.out);
      System.out.println();
      System.out.println();
   }


   void displayBusinessNames(SOAPMessage message)
      throws SOAPException
   {
      SOAPElement element;
      Iterator iter;

      element = helper.getMessageBody(message);
      element =
         helper.findSubelement(element, "businessInfos");

      iter = element.getChildElements();
      while (iter.hasNext())
      {
         element = (SOAPElement)iter.next();
         element = helper.findSubelement(element, "name");
         System.out.println(element.getValue());
      }
   }
}
