import org.jdom.Attribute;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.lang.reflect.Method;


class AttributeHandler
{

   AttributeHandler(Class eltClass, JComponent component,
                    Object attrib, JPanel panel)
      throws Exception
   {
      String attName = ((Attribute)attrib).getName();
      String attValue = ((Attribute)attrib).getValue();


      //-------Layout---------------//
      if (attName.equals("Layout"))
      {
        LayoutManager layoutManager =
         (LayoutManager)Class.forName
                                   (attValue).newInstance();
        ((JPanel)component).setLayout(layoutManager);
      }


      //-------Region---------------//
      else if (attName.equals("Region"))
         panel.add(component, attValue);


      //-------Other----------------//
      else
      {
         Method method;
         Object[] params = new Object[1];
         final Class[] oneIntParam = {int.class};
         final Class[] oneStringParam = {String.class};

         try
         {
            params[0] = new Integer(attValue);
            method = eltClass.getMethod
                            ("set"+attName, oneIntParam);
         }
         catch (NumberFormatException e)
         {
            params[0] = attValue;
            method = eltClass.getMethod
                            ("set"+attName, oneStringParam);
         }

         method.invoke(component, params);
      }
   }

}
