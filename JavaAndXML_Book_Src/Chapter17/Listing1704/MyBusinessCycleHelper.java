import javax.xml.registry.Connection;
import javax.xml.registry.ConnectionFactory;
import javax.xml.registry.RegistryService;
import javax.xml.registry.BusinessLifeCycleManager;
import javax.xml.registry.JAXRException;

import java.net.PasswordAuthentication;

import java.util.Properties;
import java.util.HashSet;


class MyBusinessCycleHelper extends MyBusinessHelper
{

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
         ("javax.xml.registry.lifeCycleManagerURL",
          "https://www.systinet.com:443/" +
          "wasp/uddi/publishing/");
      properties.setProperty
         ("javax.xml.registry.factoryClass",
         "com.sun.xml.registry.uddi.ConnectionFactoryImpl");

      factory = ConnectionFactory.newInstance();
      factory.setProperties(properties);

      connection =  factory.createConnection();
      registryService = connection.getRegistryService();
   }


   BusinessLifeCycleManager createBusinessLifeCycleManager()
      throws JAXRException
   {
      return registryService.getBusinessLifeCycleManager();
   }


   void addCredentials()
      throws JAXRException
   {
      PasswordAuthentication authentication;
      HashSet credentials;

      char[] password = 
         {'s','w','o','r','d','f','i','s','h'};
      authentication =
         new PasswordAuthentication("myUsername", password);

      credentials = new HashSet();
      credentials.add(authentication);

      System.setProperty("java.protocol.handler.pkgs",
         "com.sun.net.ssl.internal.www.protocol");
      System.setProperty("javax.net.ssl.trustStore",
         "C:\\JavaPrograms\\.keystore");

      connection.setCredentials(credentials);
   }

}
