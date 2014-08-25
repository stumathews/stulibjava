import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyTransform extends HttpServlet
{

   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
      throws IOException

   {
      response.setContentType("text/html");

      String docName = request.getParameter("docName");
      String sheetName = request.getParameter("sheetName");

      TransformerFactory factory;
      Transformer transformer;

      File oldFile, xslFile;
      PrintWriter out;

      StreamSource oldStream, xslStream;
      StreamResult newStream;

      factory = TransformerFactory.newInstance();

      try
      {
         oldFile = new File(docName + ".xml");
         oldStream = new StreamSource(oldFile);

         xslFile = new File(sheetName + ".xsl");
         xslStream = new StreamSource(xslFile);

         out = response.getWriter();
         newStream = new StreamResult(out);

         transformer = factory.newTransformer(xslStream);
         transformer.transform (oldStream, newStream);
      }
      catch (TransformerException e)
      {
         System.out.println(e.getMessage());
      }
   }

}
