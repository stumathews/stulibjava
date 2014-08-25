import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPException;

import javax.xml.messaging.URLEndpoint;
import java.io.IOException;


public class AskUDDIquery
{
   static SOAPConnection connection;
   static URLEndpoint endpoint;


   public static void main(String args[])
      throws SOAPException, IOException
   {
      SOAPMessage request, response;
      MyRequestMaker maker = new MyRequestMaker();
      MyDisplayer displayer = new MyDisplayer();

      request = maker.createRequest(args[0]);

      System.out.println("Sending the following message:");
      displayer.displayOnConsole(request);

      doNetworkPlumbing(args[1]);
      response = connection.call(request, endpoint);

      System.out.println("Received the following message:");
      displayer.displayOnConsole(response);

      System.out.println("Matching business names:");
      displayer.displayBusinessNames(response);

      connection.close();
   }


   static void doNetworkPlumbing(String urlEndpoint)
      throws SOAPException
   {
      SOAPConnectionFactory connFactory;

      endpoint = new URLEndpoint (urlEndpoint);
      connFactory = SOAPConnectionFactory.newInstance();
      connection = connFactory.createConnection();
   }
}
