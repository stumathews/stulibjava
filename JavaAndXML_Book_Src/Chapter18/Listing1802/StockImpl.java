package stock;

public class StockImpl implements StockIFPort
{
   public double getQuote(String company)
   {
      if (company.equals("SUNW"))
         return 17.5300;
      else
         return 8.6600;
   }

   public String getSymbol(String company)
   {
      if (company.equals("Sun"))
         return ("SUNW");
      else
         return "other";
   }
}
