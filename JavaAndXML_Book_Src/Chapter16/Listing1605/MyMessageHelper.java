import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import java.util.Iterator;


class MyMessageHelper
{

   SOAPMessage createMessageObject()
      throws SOAPException
   {
      MessageFactory messFactory =
         MessageFactory.newInstance();
      return messFactory.createMessage();
   }


   SOAPEnvelope getMessageEnvelope(SOAPMessage message)
      throws SOAPException
   {
      SOAPPart soapPart;

      soapPart = message.getSOAPPart();
      return soapPart.getEnvelope();
   }


   SOAPBody getMessageBody(SOAPMessage message)
      throws SOAPException
   {
      SOAPPart soapPart;
      SOAPEnvelope envelope;

      soapPart = message.getSOAPPart();
      envelope = soapPart.getEnvelope();
      return envelope.getBody();
   }


   static SOAPElement findSubelement(SOAPElement element,
                                     String targetQualName)
   {
      String qualName;
      Iterator iter;

      do
      {
         iter = element.getChildElements();
         element = (SOAPElement)iter.next();
         qualName =
            element.getElementName().getQualifiedName();
      }
      while (!qualName.equals(targetQualName));

      return element;
   }

}
