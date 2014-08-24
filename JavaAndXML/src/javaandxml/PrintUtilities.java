/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaandxml;

/**
 *
 * @author Stuart
 */
public class PrintUtilities 
{
  public static void println(String mString)
  {
    if( mString.isEmpty())
      System.out.println();
    else
      System.out.println(mString);
  }
}
