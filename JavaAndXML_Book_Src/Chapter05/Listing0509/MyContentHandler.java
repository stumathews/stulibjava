import org.xml.sax.helpers.DefaultHandler;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

class MyContentHandler extends DefaultHandler
{
   PrintStream log = null;


   public void processingInstruction (String target,
                                      String data)
   {
      System.out.println("Processing instruction");
      System.out.println("\tTarget: " + target);
      System.out.println("\tData  : " + data);

      if (target.equals("debug"))
         try
         {
            FileOutputStream f =
               new FileOutputStream(data);
            log = new PrintStream(f);
         }
         catch (FileNotFoundException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
   }


   public void characters
      (char[] charArray, int start, int length)
   {
      String charString =
         (new String(charArray, start, length)).trim();
      if (charString != null && log != null)
         log.print (charString);

   }

}
