import javax.swing.JFrame;
import javax.swing.JTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import java.awt.BorderLayout;


class MyFrame extends JFrame
{
   MyFrame (Document doc)
   {
      Node docRoot = doc.getDocumentElement();

      JTree tree = makeTree(docRoot);

      getContentPane().add(tree);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500,500);
      show();
   }


   JTree makeTree(Node docRoot)
   {
      MyTreeNode treeRoot = new MyTreeNode();
      new TreeExtender(treeRoot, docRoot);
      return new JTree(treeRoot);
   }
}
