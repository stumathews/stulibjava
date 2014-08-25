import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;


class GoAhead_MakeMyJ
{
   public static void main(String args[])
   {
      new MyJFrame();
   }
}


class MyJFrame extends JFrame
{
   MyJFrame()
   {
      JPanel pane = (JPanel)getContentPane();

      JPanel northPanel = new JPanel();
      pane.add(northPanel, "North");
      northPanel.setLayout(new BorderLayout());

         JPanel westPanel = new JPanel();
         northPanel.add(westPanel, "West");

            JButton copyButton = new JButton();
            westPanel.add(copyButton);
            copyButton.setText("Copy");

            JButton cutButton = new JButton();
            westPanel.add(cutButton);
            cutButton.setText("Cut");

            JButton pasteButton = new JButton();
            westPanel.add(pasteButton);
            pasteButton.setText("Paste");

         JPanel eastPanel = new JPanel();
         northPanel.add(eastPanel, "East");

            JButton helpButton = new JButton();
            eastPanel.add(helpButton);
            helpButton.setText("Help");

      JPanel centerPanel = new JPanel();
      pane.add(centerPanel, "Center");
      centerPanel.setLayout(new GridLayout());

         JTextArea textarea = new JTextArea();
         centerPanel.add(textarea);
         textarea.setRows(10);
         textarea.setColumns(40);
         textarea.setText("Java and XML For Dummies");

      JPanel southPanel = new JPanel();
      pane.add(southPanel, "South");

         JLabel label = new JLabel();
         southPanel.add(label);
         label.setText("Status:");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      show();
   }
}
