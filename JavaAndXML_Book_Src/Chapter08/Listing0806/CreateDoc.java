import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Comment;
import org.w3c.dom.Attr;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.OutputKeys;
import
   javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

class CreateDoc
{
   static Document doc;
   static Element rootElt;

   public static void main(String args[])
      throws ParserConfigurationException,
             TransformerConfigurationException,
             TransformerException
   {

      makeDOMdoc();
      addProcessingInstruction();
      addComment();
      makeRootElt();
      addAttribute();
      addElements(args);
      outputFile();
   }


   static void makeDOMdoc()
      throws ParserConfigurationException
   {
      DocumentBuilderFactory factory =
         DocumentBuilderFactory.newInstance();
      DocumentBuilder builder =
         factory.newDocumentBuilder();
      doc = builder.newDocument();
   }


   static void addProcessingInstruction()
   {
      ProcessingInstruction pi =
         doc.createProcessingInstruction
            ("xml-stylesheet",
            "type=\"text/xsl\" href=\"ThoughtFormat.xsl\"");
      doc.appendChild(pi);
   }


   static void addComment()
   {
      Comment comment =
         doc.createComment("Author: H.Ritter");
      doc.appendChild(comment);
   }


   static void makeRootElt()
   {
      rootElt = doc.createElement("BovineBeautyProducts");
      doc.appendChild(rootElt);
   }


   static void addAttribute()
   {
      Attr attrib = doc.createAttribute("customerResponse");
      attrib.setValue("Moo");
      rootElt.setAttributeNode(attrib);
   }


   static void addElements(String[] args)
   {
      for (int i=0; i<args.length; i++)
      {
         Node eltNode = doc.createElement("Item");
         rootElt.appendChild(eltNode);
         Node textNode = doc.createTextNode(args[i]);
         eltNode.appendChild(textNode);
      }
   }


   static void outputFile()
      throws TransformerConfigurationException,
             TransformerException
   {
      File file = new File("BovineBeautyProducts.xml");

      TransformerFactory transformerFactory =
         TransformerFactory.newInstance();
      Transformer transformer =
         transformerFactory.newTransformer();
      transformer.setOutputProperty
                           (OutputKeys.INDENT, "yes");

      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(file);

      transformer.transform(source, result);
   }
}
