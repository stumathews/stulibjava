import javax.xml.registry.BusinessQueryManager;
import javax.xml.registry.BulkResponse;
import javax.xml.registry.JAXRException;

import java.util.Vector;


public class DoQuery
{
   public static void main(String[] args)
      throws JAXRException
   {
      MyBusinessHelper helper;
      BusinessQueryManager manager;
      Vector names;
      BulkResponse response;


      helper = new MyBusinessHelper();
      helper.createConnection();

      manager = helper.createBusinessQueryManager();

      names = new Vector();
      names.add("%Burd%");
      response = manager.findOrganizations
        (null, names, null, null, null, null);

      helper.displayResults(response);
   }
}
