import java.util.List;
import org.jdom.Element;
import org.jdom.Comment;
import org.jdom.ProcessingInstruction;
import org.jdom.Attribute;

class MyContentTraverser
{

   MyContentTraverser(List content)
   {
      Object obj;

      for (int i=0; i<content.size(); i++)
      {
         obj = content.get(i);

         if (obj instanceof Comment)
         {
            Comment comment = (Comment)obj;

            System.out.print("Comment: ");
            System.out.println
               (Revealer.reveal(comment.getText()));
         }

         if (obj instanceof ProcessingInstruction)
         {
            ProcessingInstruction pi =
               (ProcessingInstruction)obj;

            System.out.print("Processing instruction: ");
            System.out.print(pi.getTarget());
            System.out.print(" ");
            System.out.println(pi.getData());
         }

         if (obj instanceof Element)
         {
            Element elt = (Element)obj;

            System.out.print("Element: ");
            System.out.println(elt.getName());

            System.out.print("Attributes: ");
            List attribs = elt.getAttributes();
            for (int j=0; j<attribs.size(); j++)
            {
               Attribute attrib = (Attribute)attribs.get(j);

               System.out.print(attrib.getName());
               System.out.print(" = ");
               System.out.println(attrib.getValue());
            }

            System.out.print("Text: ");
            System.out.println
               (Revealer.reveal(elt.getText()));

            new MyContentTraverser(elt.getContent());
         }
      }
   }

}
