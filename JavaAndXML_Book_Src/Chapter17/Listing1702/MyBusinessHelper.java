import javax.xml.registry.Connection;
import javax.xml.registry.ConnectionFactory;
import javax.xml.registry.RegistryService;
import javax.xml.registry.BusinessQueryManager;
import javax.xml.registry.BulkResponse;
import javax.xml.registry.JAXRException;

import javax.xml.registry.infomodel.Organization;
import javax.xml.registry.infomodel.Key;
import javax.xml.registry.infomodel.Service;

import java.util.Properties;
import java.util.Collection;
import java.util.Iterator;


class MyBusinessHelper
{
   Connection connection;
   RegistryService registryService;


   void createConnection()
      throws JAXRException
   {
      Properties properties;
      ConnectionFactory factory;

      properties = new Properties();
      properties.setProperty
         ("javax.xml.registry.queryManagerURL",
         "http://www.systinet.com:80/wasp/uddi/inquiry/");
      properties.setProperty
         ("javax.xml.registry.factoryClass",
         "com.sun.xml.registry.uddi.ConnectionFactoryImpl");

      factory = ConnectionFactory.newInstance();
      factory.setProperties(properties);

      connection =  factory.createConnection();
      registryService = connection.getRegistryService();
   }


   BusinessQueryManager createBusinessQueryManager()
      throws JAXRException
   {
      return registryService.getBusinessQueryManager();
   }


   void displayResults(BulkResponse response)
      throws JAXRException
   {
      Collection organizations;
      Organization organization;
      Collection services;
      Service service;
      Iterator orgIterator, servIterator;

      organizations = response.getCollection();

      orgIterator = organizations.iterator();
      while (orgIterator.hasNext())
      {
         organization = (Organization) orgIterator.next();

         System.out.print("Organization: ");
         System.out.println
            (organization.getName().getValue());

         services = organization.getServices();
         servIterator = services.iterator();
         while (servIterator.hasNext())
         {
            service = (Service) servIterator.next();

            System.out.print("\tService: " );
            System.out.println
               (service.getName().getValue());
         }
      }
   }
}
