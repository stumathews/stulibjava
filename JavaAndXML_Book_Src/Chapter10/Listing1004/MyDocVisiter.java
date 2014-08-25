import org.jdom.Document;
import org.jdom.DocType;
import java.util.List;

class MyDocVisiter
{
   MyDocVisiter(Document doc)
   {
      List content;
      DocType docType;

      if ((docType=doc.getDocType()) != null)
      {
         System.out.print("DOCTYPE: ");
         System.out.println(docType.getSystemID());
      }

      content = doc.getContent();
      new MyContentTraverser(content);
   }

}
