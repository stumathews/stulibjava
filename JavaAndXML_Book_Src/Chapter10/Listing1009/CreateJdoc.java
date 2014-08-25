import org.jdom.Document;
import org.jdom.ProcessingInstruction;
import org.jdom.Comment;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class CreateJdoc
{
   static Document doc;
   static Element rootElt;

   public static void main(String args[])
   {
      makeRootElt();
      makeJDOMdoc();
      addProcessingInstruction();
      addComment();
      addAttribute();
      addElements(args);
      outputFile();
   }


   static void makeRootElt()
   {
      rootElt = new Element("BovineBeautyProducts");
   }


   static void makeJDOMdoc()
   {
      doc = new Document(rootElt);
   }


   static void addProcessingInstruction()
   {
      ProcessingInstruction pi = new ProcessingInstruction
         ("xml-stylesheet",
          "type=\"text/xsl\" href=\"Cows.xsl\"");
      doc.addContent(pi);
   }


   static void addComment()
   {
      Comment comment = new Comment("Author: H.Ritter");
      doc.addContent(comment);
   }


   static void addElements(String args[])
   {
      Element elt;

      for (int i=0; i<args.length; i++)
      {
         elt = new Element("Item");
         rootElt.addContent(elt);
         elt.addContent(args[i]);
      }
   }


   static void addAttribute()
   {
      rootElt.setAttribute("customerResponse", "Moo");
   }


   static void outputFile()
   {
      try
      {
         File file = new File("BovineBeautyProducts.xml");
         FileOutputStream result =
            new FileOutputStream(file);

         XMLOutputter outputter = new XMLOutputter();
         outputter.setNewlines(true);
         outputter.setIndent("   ");

         outputter.output(doc, result);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

}
