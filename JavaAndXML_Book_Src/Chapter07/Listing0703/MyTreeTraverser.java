import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;


class MyTreeTraverser
{

   MyTreeTraverser (Node node)
   {
      System.out.println(node.getNodeName());


      node = node.getFirstChild();
      System.out.println(node.getNodeName());

      node = node.getNextSibling();
      System.out.println(node.getNodeName());

      node = node.getFirstChild();
      System.out.println(node.getNodeName());

      node = node.getNextSibling();
      System.out.println(node.getNodeName());
   }

}
