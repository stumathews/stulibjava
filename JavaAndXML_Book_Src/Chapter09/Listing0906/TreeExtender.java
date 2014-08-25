import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;


class TreeExtender
{
   MyTreeNode treeNode;
   Node docNode;


   TreeExtender (MyTreeNode treeNode, Node docNode)
   {
      this.treeNode = treeNode;
      this.docNode = docNode; 

      treeNode.setUserObject(getLabel());
      addChildren();
   }


   void addChildren()
   {
      Node docChild = docNode.getFirstChild();
      while (docChild != null)
      {
         if (shouldDisplay(docChild))
         {
            MyTreeNode treeChild = new MyTreeNode();
            treeNode.add(treeChild);
            new TreeExtender(treeChild, docChild);
         }
         docChild = docChild.getNextSibling();
      }
   }


   boolean shouldDisplay(Node docChild)
   {
      if (docChild.getNodeType() == Node.TEXT_NODE)
      {
         String nodeValue = docChild.getNodeValue();
         if (nodeValue != null &&
             !nodeValue.trim().equals(""))
            return true;
         else
            return false;
      }
      else
         return true;
   }


   String getLabel()
   {
      short nodeType = docNode.getNodeType();

      if (nodeType == Node.TEXT_NODE)
         return docNode.getNodeValue();
      else if (nodeType == Node.ELEMENT_NODE)
         return docNode.getNodeName() + stringOfAttribs();
      else
         return docNode.getNodeName();
   }


   String stringOfAttribs()
   {
      NamedNodeMap attribs = docNode.getAttributes();
      String label = "";

      for (int i = 0; i < attribs.getLength(); i++)
      {
         Node item = attribs.item(i);
         label += "    ";
         label += item.getNodeName();
         label += " = \"";
         label += item.getNodeValue();
         label += "\"";
      }

      return label;
   }

}
