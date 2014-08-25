import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import javax.xml.bind.UnmarshalException;
import javax.xml.bind.StructureValidationException;

import java.util.List;
import java.util.Iterator;


class UpdateTotal
{
   static Salesperson salesperson;

   public static void main(String args[])
      throws IOException, UnmarshalException
   {
      Sale sale;

      String fullName;
      double total, newTotal;
      String itemName;
      double unitCost;
      int quantity;

      List saleList;
      Iterator saleIterator;

      salesperson = readSalesperson();

      fullName = salesperson.getFullName();
      total = salesperson.getTotal();
      newTotal=total;

      saleList = salesperson.getSale();
      saleIterator = saleList.iterator();

      System.out.println(fullName + " sold");

      while (saleIterator.hasNext())
      {
         sale = (Sale)saleIterator.next();

         itemName = sale.getItemName();
         unitCost = sale.getUnitCost();
         quantity = sale.getQuantity();
         newTotal += unitCost*quantity;

         System.out.print("\t" + quantity);
         System.out.println(" " + itemName + "s");

         saleIterator.remove();
      }

      salesperson.setTotal(newTotal);
      writeSalesperson();
   }


   static Salesperson readSalesperson()
      throws FileNotFoundException, UnmarshalException
   {
      FileInputStream salespersonIn =
         new FileInputStream("Salesperson.xml");

      salesperson = Salesperson.unmarshal(salespersonIn);

      return salesperson;
   }


   static void writeSalesperson()
      throws IOException, StructureValidationException
   {
      FileOutputStream salespersonOut =
         new FileOutputStream("Salesperson.xml");

      salesperson.validate();
      salesperson.marshal(salespersonOut);
   }
}
