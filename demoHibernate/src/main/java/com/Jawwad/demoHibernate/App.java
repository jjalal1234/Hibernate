package com.Jawwad.demoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	employees emp = new employees();
    	emp.setId(4);
    	emp.setLast_name("Williams");
    	emp.setFirst_name("David");
    	emp.setEmail("David.Williams@foo.com");
    	emp.setDepartment("Engineering");
    	emp.setSalary(85000);
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(employees.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory mySf = config.buildSessionFactory(reg);
    	Session session = mySf.openSession();
    	Transaction Tx = session.beginTransaction();
    	session.save(emp);    	
    	Tx.commit();
    	System.out.println(emp);
    }
}
