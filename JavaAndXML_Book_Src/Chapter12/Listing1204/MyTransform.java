import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


public class MyTransform
{
   public static void main(String[] args)
      throws TransformerException,
             FileNotFoundException

   {
      TransformerFactory factory;
      Transformer transformer;

      File oldFile, xslFile, newFile;
      StreamSource oldStream, xslStream;
      StreamResult newStream;

      factory = TransformerFactory.newInstance();

      if (args.length == 3)
      {
         oldFile = new File(args[0]);
         oldStream = new StreamSource(oldFile);

         xslFile = new File(args[1]);
         xslStream = new StreamSource(xslFile);

         newFile = new File(args[2]);
         newStream = new StreamResult(newFile);

         transformer = factory.newTransformer(xslStream);
         transformer.transform (oldStream, newStream);
      }
      else
      {
         System.out.print ("Usage: java MyTransform ");
         System.out.println("old.xml xform.xsl new.xml");
      }
  }
}
