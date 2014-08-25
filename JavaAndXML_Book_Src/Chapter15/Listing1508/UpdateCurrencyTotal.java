import java.text.NumberFormat;

import java.io.IOException;
import javax.xml.bind.UnmarshalException;
import java.util.List;
import java.util.Iterator;


class UpdateCurrencyTotal extends UpdateTotal
{
   public static void main(String args[])
      throws IOException, UnmarshalException
   {
      Sale sale;

      String fullName;
      String total, newTotal;
      double doubleTotal;

      String itemName;
      double unitCost;
      int quantity;

      List saleList;
      Iterator saleIterator;

      salesperson = readSalesperson();

      fullName = salesperson.getFullName();
      total = salesperson.getTotal();
      doubleTotal = Double.parseDouble(total);

      saleList = salesperson.getSale();
      saleIterator = saleList.iterator();

      System.out.println(fullName + " sold");

      while (saleIterator.hasNext())
      {
         sale = (Sale)saleIterator.next();

         itemName = sale.getItemName();
         unitCost = sale.getUnitCost();
         quantity = sale.getQuantity();
         doubleTotal += unitCost*quantity;

         System.out.print("\t" + quantity);
         System.out.println(" " + itemName + "s");

         saleIterator.remove();
      }

      NumberFormat currency =
         NumberFormat.getCurrencyInstance();
      newTotal = currency.format(doubleTotal);
      salesperson.setTotal(newTotal);
      writeSalesperson();
   }

}
