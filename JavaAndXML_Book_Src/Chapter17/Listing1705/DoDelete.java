import javax.xml.registry.BusinessQueryManager;
import javax.xml.registry.BusinessLifeCycleManager;
import javax.xml.registry.BulkResponse;
import javax.xml.registry.JAXRException;

import javax.xml.registry.infomodel.Organization;

import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;


public class DoDelete
{
   public static void main(String[] args)
      throws JAXRException
   {
      MyBusinessCycleHelper helper;
      BusinessQueryManager queryManager;
      BusinessLifeCycleManager cycleManager;
      BulkResponse response;
      Organization organization;
      Collection organizations;
      Vector keys;
      Iterator iterator;
      String orgName;


      helper = new MyBusinessCycleHelper();
      helper.createConnection();
      helper.addCredentials();

      queryManager = helper.createBusinessQueryManager();
      response = queryManager.getRegistryObjects();


      organizations = response.getCollection();
      iterator = organizations.iterator();
      keys = new Vector();

      while (iterator.hasNext())
      {
         organization = (Organization)iterator.next();
         orgName = organization.getName().getValue();
         System.out.print(orgName);

         if (orgName.indexOf("Burd") != -1)
         {
            keys.add(organization.getKey());
            System.out.print(" is being DELETED.");
         }
         else
         {
            System.out.print(" is NOT being deleted.");
         }

         System.out.println();
      }

      if (!keys.isEmpty())
      {
         cycleManager =
            helper.createBusinessLifeCycleManager();
         cycleManager.deleteOrganizations(keys);
      }
   }
}
