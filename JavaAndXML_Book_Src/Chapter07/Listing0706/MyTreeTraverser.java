import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.DocumentType;

class MyTreeTraverser
{

   MyTreeTraverser (Node node)
   {
      System.out.println (getNodeInfo(node));

      NamedNodeMap attribs = node.getAttributes();
      visitAll(attribs);


      if (node.getNodeType() == Node.DOCUMENT_TYPE_NODE)
      {
         NamedNodeMap entities =
                        ((DocumentType)node).getEntities();
         visitAll(entities);

         NamedNodeMap notations =
                        ((DocumentType)node).getNotations();
         visitAll(notations);
      }


      Node child = node.getFirstChild();
      while (child != null)
      {
         new MyTreeTraverser(child);
         child = child.getNextSibling();
      }
   }


   final static String [] nodeTypes =
                           {"none",
                            "ELEMENT_NODE",
                            "ATTRIBUTE_NODE",
                            "TEXT_NODE",
                            "CDATA_SECTION_NODE",
                            "ENTITY_REFERENCE_NODE",
                            "ENTITY_NODE",
                            "PROCESSING_INSTRUCTION_NODE",
                            "COMMENT_NODE",
                            "DOCUMENT_NODE",
                            "DOCUMENT_TYPE_NODE",
                            "DOCUMENT_FRAGMENT_NODE",
                            "NOTATION_NODE"};


   String getNodeInfo(Node node)
   {
      String nodeInfo = nodeTypes[node.getNodeType()];
      nodeInfo += ", ";
      nodeInfo += node.getNodeName();
      nodeInfo += ", ";

      String nodeValue = node.getNodeValue();
      if (nodeValue != null)
      {
         nodeValue = nodeValue.replaceAll("\n", "[cr]");
         nodeValue = nodeValue.replaceAll(" ", ".");
      }
      nodeInfo += nodeValue;

      return nodeInfo;
   }


   void visitAll (NamedNodeMap nodeMap)
   {
      if (nodeMap != null)
         for (int i = 0; i<nodeMap.getLength(); i++)
         {
            Node node = nodeMap.item(i);
            System.out.println (getNodeInfo(node));
         }
   }
}
