import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

class MyContentHandler extends DefaultHandler
{
   public void startElement(String uri,
                            String localName,
                            String qualName,
                            Attributes attribs)
   {
      System.out.println("Start element:");
      System.out.println("\tURI: " + uri);
      System.out.println("\tlocalName: " + localName);
      System.out.println("\tqualName: "  + qualName);

      for (int i=0; i<attribs.getLength(); i++)
      {
         System.out.println("\tAttribute:");
         System.out.print("\t\tURI: ");
         System.out.println(attribs.getURI(i));
         System.out.print("\t\tLocal name: ");
         System.out.println(attribs.getLocalName(i));
         System.out.print("\t\tQualified name: ");
         System.out.println(attribs.getQName(i));
         System.out.print("\t\tType: ");
         System.out.println(attribs.getType(i));
         System.out.print("\t\tValue: ");
         System.out.println(attribs.getValue(i));
      }
   }


   public void startPrefixMapping(String prefix, String uri)
   {
      System.out.println("Start prefix mapping:");
      System.out.println("\tPrefix: " + prefix);
      System.out.println("\turi: "   + uri);
   }


   public void endPrefixMapping(String prefix)
   {
      System.out.println("End prefix mapping: ");
      System.out.println("\tPrefix: " + prefix);
   }
}
