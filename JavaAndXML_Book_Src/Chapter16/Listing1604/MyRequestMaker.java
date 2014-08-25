import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPException;


class MyRequestMaker
{
   SOAPMessage request;
   MyMessageHelper helper = new MyMessageHelper();


   SOAPMessage createRequest(String businessName)
      throws SOAPException
   {
      request = helper.createMessageObject();
      composeRequest(businessName);
      return request;
   }


   void composeRequest (String businessName)
      throws SOAPException
   {
      SOAPEnvelope envelope;
      SOAPElement element;
      Name name;

      envelope = helper.getMessageEnvelope(request);
      element = helper.getMessageBody(request);

      element = element.addChildElement
         ("find_business", "", "urn:uddi-org:api");

      name = envelope.createName("generic");
      element.addAttribute(name, "1.0");

      element = element.addChildElement("name");
      element.addTextNode(businessName);

      request.saveChanges();
   }
}
