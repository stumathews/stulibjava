import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;


class MyTreeTraverser
{
   Node node;


   MyTreeTraverser (Node node)
   {
      this.node = node;

      displayName();
      displayNamespaceStuff();
      displayValue();
      if (node.getNodeType() == Node.ELEMENT_NODE)
         displayAttributes();

      System.out.println();

      displayChildren();
   }


   void displayName()
   {
      System.out.print("Name: ");
      System.out.println(node.getNodeName());
   }


   void displayNamespaceStuff()
   {
      String namespaceURI = node.getNamespaceURI();
      if (namespaceURI != null)
      {
         System.out.print("Namespace URI: ");
         System.out.println(namespaceURI);

         System.out.print("Prefix: ");
         System.out.println(node.getPrefix());

         System.out.print("Local name: ");
         System.out.println(node.getLocalName());
      }
   }


   void displayValue()
   {
      String nodeValue = node.getNodeValue();
      if (nodeValue != null)
         nodeValue = nodeValue.trim();

      System.out.print("Value: ");
      System.out.println(nodeValue);
   }


   void displayAttributes()
   {
      NamedNodeMap attribs = node.getAttributes();

      for (int i = 0; i < attribs.getLength(); i++)
      {
         System.out.println();
         System.out.print("Attribute: ");
         System.out.print(attribs.item(i).getNodeName());
         System.out.print(" = ");
         System.out.println(attribs.item(i).getNodeValue());
      }
   }


   void displayChildren()
   {
      Node child = node.getFirstChild();
      while (child != null)
      {
         new MyTreeTraverser(child);
         child = child.getNextSibling();
      }
   }

}
