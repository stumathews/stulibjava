import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPException;

import javax.xml.messaging.JAXMServlet;
import javax.xml.messaging.ReqRespListener;


public class AnswerUDDIquery extends JAXMServlet
   implements ReqRespListener
{

   public SOAPMessage onMessage(SOAPMessage request)
   {
      try
      {
         SOAPMessage response;
         String businessName;

         MyResponseMaker maker =
            new MyResponseMaker(request);

         response = maker.createResponse();

         return response;
      }
      catch(SOAPException e)
      {
         e.printStackTrace();
         return null;
      }
   }
}
