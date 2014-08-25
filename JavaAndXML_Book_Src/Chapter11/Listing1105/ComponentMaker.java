import org.jdom.Element;
import org.jdom.Attribute;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.util.List;


class ComponentMaker
{

   ComponentMaker (Element elt, JPanel panel)
      throws Exception
   {
      Class eltClass =
         Class.forName("javax.swing." + elt.getName());
      JComponent component =
         (JComponent)eltClass.newInstance();


      List attribs = elt.getAttributes();
      for (int i=0; i<attribs.size(); i++)
         new AttributeHandler (eltClass, component,
                               attribs.get(i), panel);

      if (!panel.isAncestorOf(component))
         panel.add(component);


      List children = elt.getChildren();
      for (int i=0; i<children.size(); i++)
         new ComponentMaker
           ((Element)children.get(i), (JPanel)component);
   }

}
