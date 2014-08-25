package stock;

import java.rmi.RemoteException;

public class StockClient
{
   public static void main(String[] args)
      throws RemoteException
   {
      String symbol;
      double quote;

      StockIFPort_Stub stub = (StockIFPort_Stub)
         (new StockQuote_Impl().getStockIFPort());

      symbol = stub.getSymbol("Sun");
      quote = stub.getQuote(symbol);

      System.out.println("Sun Microsystems: " + quote);
   }
}
