import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;


class MyTreeTraverser
{
   private String day;

   MyTreeTraverser (Node node)
   {

      NamedNodeMap attribs = node.getAttributes();
      day = attribs.getNamedItem("day").getNodeValue();

      Node child = node.getFirstChild();
      while (child != null)
      {
         String childNodeName = child.getNodeName();
         if (childNodeName.equals("Mail"))
            new MyTreeTraverser(child);
         if (childNodeName.equals("Item"))
            handleItem(child);

         child = child.getNextSibling();
      }
   }


   void handleItem(Node child)
   {
      String text = child.getFirstChild().getNodeValue();
      if (text != null && !text.equals(""))
      {
         System.out.print("Received ");
         System.out.print(day);
         System.out.print("-\t");
         System.out.println(text);
      }
   }
}
