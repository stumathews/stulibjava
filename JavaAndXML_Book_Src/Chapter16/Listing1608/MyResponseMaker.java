import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPException;


class MyResponseMaker
{
   SOAPMessage request, response;
   MyMessageHelper helper = new MyMessageHelper();


   MyResponseMaker (SOAPMessage request)
   {
      this.request = request;
   }


   SOAPMessage createResponse ()
      throws SOAPException
   {
      String businessName;

      response = helper.createMessageObject();
      businessName = getBusinessName();
      composeResponse(businessName);
      return response;
   }


   String getBusinessName()
      throws SOAPException
   {
      SOAPElement element;

      element = helper.getMessageBody(request);
      element = helper.findSubelement(element, "name");
      return element.getValue();
   }


   void composeResponse(String businessName)
      throws SOAPException
   {
      SOAPEnvelope envelope;
      SOAPElement element;
      Name name;

      envelope = helper.getMessageEnvelope(response);
      element = helper.getMessageBody(response);

      element = element.addChildElement
         ("businessList", "", "urn:uddi-org:api");
      name = envelope.createName("generic");
      element.addAttribute(name, "1.0");

      element = element.addChildElement("businessInfos");

      element = element.addChildElement("businessInfo");
      name = envelope.createName("businessKey");
      element.addAttribute(name, "000A00-A000");

      element = element.addChildElement("name");
      element.addTextNode
        (businessName + "'s Turing Machine Repair Service");
   }
}
