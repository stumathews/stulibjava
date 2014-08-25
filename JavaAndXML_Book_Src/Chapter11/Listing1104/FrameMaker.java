import org.jdom.Document;
import org.jdom.Element;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.List;


class FrameMaker
{

   FrameMaker (Document doc) throws Exception
   {
      JFrame frame = new JFrame();
      JPanel pane = (JPanel)frame.getContentPane();

      List children = doc.getRootElement().getChildren();

      for (int i=0; i<children.size(); i++)
         new ComponentMaker((Element)children.get(i), pane);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.show();
   }

}
