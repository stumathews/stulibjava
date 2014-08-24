/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaandxml;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaandxml.PrintUtilities.println;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Stuart
 */
class MyContentHandler extends DefaultHandler 
{
  Locator locator;
  PrintStream log = null;
  public MyContentHandler() 
  {
    
  }
  
  @Override
  public void setDocumentLocator( Locator locator)
  {
    this.locator = locator;
  }
  
  @Override
  public void startDocument()
  {
    println("STATRTING");
    println("");
  }
  
  @Override
  public void startElement( String uri, String localName, String qualName, Attributes attribs)
  {
    println("Start tag:");
    println(qualName);
  }
  
  @Override
  public void endDocument()
  {
    println("");
    println("ENDING NORMALLY");
  
  }
  
  @Override
  public void characters( char[] charArray, int start, int length)
  {
    println("CHARACTERS: ");
    myWriteString(charArray, start, length);
  }
  
  @Override 
  public void ignorableWhitespace( char[] charArray, int start, int length)
  {
    println("IGNORABLE WHITESPACE: ");
    myWriteString(charArray, start, length);
  }
  
  @Override
  public void processingInstruction( String target, String data)
  {
    println("Processing instruction");
    println("\tTtarget: " + target);
    println("\tData:"+ data);
    
    if( target.equals("debug"))
    {
      try
      {
        FileOutputStream f = new FileOutputStream(data);
        log = new PrintStream(f);
      } catch (FileNotFoundException ex) 
      {
        ex.printStackTrace();
        System.exit(1);
      }
    }
  }
  
  
  private void showSpecifics()
  {
    println(" Line " + locator.getLineNumber());
    println(" Column " + locator.getColumnNumber());
    println(" Document " + locator.getSystemId());
  }

  private void myWriteString(char[] charArray, int start, int length) 
  {
    String charString = new String(charArray, start, length).trim();
    charString = charString.replaceAll("\n", "[cr]");
    
    if( charString != null && log != null)
    {
      log.print(charString);
    }
  }
  
}
