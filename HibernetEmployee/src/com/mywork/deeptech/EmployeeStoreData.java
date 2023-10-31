package com.mywork.deeptech;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
public class EmployeeStoreData {

	public static void main(String[] args) {
        StandardServiceRegistry s=new StandardServiceRegistryBuilder().configure("hibconfig.cfg.xml").build();
        Metadata meta= new MetadataSources(s).getMetadataBuilder().build();
      //connection between java application with data establish time
        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession(); 
        org.hibernate.Transaction t=session.beginTransaction();
        Employee e1=new Employee();
        e1.setEmpname("Pavithraaa");
        e1.setDesignation("Manager");
        e1.setSalary(97000);
        session.save(e1);
        t.commit();
        System.out.println("Data saved");
        factory.close();
        session.close();
	}
}
