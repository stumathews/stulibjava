import javax.xml.registry.BusinessLifeCycleManager;
import javax.xml.registry.JAXRException;

import javax.xml.registry.infomodel.Organization;
import javax.xml.registry.infomodel.Service;

import java.util.Vector;


public class DoPublish
{
   public static void main(String[] args)
      throws JAXRException
   {
      MyBusinessCycleHelper helper;
      BusinessLifeCycleManager manager;
      Organization organization;
      Service service;
      Vector organizations;


      helper = new MyBusinessCycleHelper();
      helper.createConnection();
      helper.addCredentials();

      manager = helper.createBusinessLifeCycleManager();

      organization = manager.createOrganization
                             ("Burd Brain Consulting");
      service = manager.createService("Java Training");
      organization.addService(service);

      organizations = new Vector();
      organizations.add(organization);

      manager.saveOrganizations(organizations);
   }
}
