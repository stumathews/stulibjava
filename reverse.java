/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        StringBuilder name = new StringBuilder("BEAUTIFUL");
        int length = name.length();
        
        for( int i = 0; i < (length/2);i++ )
        {
            char tmp = name.charAt(i);
            int rightpos = (length-1)-i;
            
            name.setCharAt(i, name.charAt(rightpos));
            name.setCharAt(rightpos, tmp);
            
        }
        System.out.println(name);
    }
}
