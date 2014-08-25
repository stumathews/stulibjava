package stock;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockIFPort extends Remote
{
   public double getQuote(String s) throws RemoteException;

   public String getSymbol(String s) throws RemoteException;
}
