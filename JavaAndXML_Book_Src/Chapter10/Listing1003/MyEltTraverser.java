import org.jdom.Element;
import java.util.List;

class MyEltTraverser
{

   MyEltTraverser(Element element, int level)
   {
      Element child;
      List children;

      System.out.print(getLines(level));
      System.out.println(element.getAttributeValue("id"));


      children = element.getChildren();
      for (int i=0; i<children.size(); i++)
      {
         child = (Element)children.get(i);
         new MyEltTraverser(child, level+1);
      }

   }


   String getLines(int level)
   {
      String lines="";
      for (int i=0; i<level; i++)
         lines += "  |";
      lines += "\n";
      for (int i=0; i<level; i++)
         lines += "  |";
      lines += "__";
      return lines;
   }

}
