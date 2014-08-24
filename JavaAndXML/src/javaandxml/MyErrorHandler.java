/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaandxml;

import static javaandxml.PrintUtilities.println;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Stuart
 */
class MyErrorHandler extends DefaultHandler 
{

  public MyErrorHandler() 
  {
    
  }
  
  @Override
  public void warning( SAXParseException e)
  {
    report("Warning:",e);
  }

  private void report(String errorTypeString, SAXParseException e) 
  {
    println(errorTypeString);
    showSpecifics(e);
    println("");
  }
  
  @Override
  public void error( SAXParseException e)
  {
    report("Error::",e);
  }
  @Override
  public void fatalError( SAXParseException e)
  {
    report("fatalError:",e);
  }
  
  public void showSpecifics( SAXParseException e)
  {
    println(e.getMessage());
    println(" Line " + e.getLineNumber());
    println(" Column " + e.getColumnNumber());
    println(" Document " + e.getSystemId());
  }
  
}
