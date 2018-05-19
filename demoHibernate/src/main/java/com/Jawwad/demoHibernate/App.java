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
    	empName name = new empName();
    	name.setFname("John");
    	name.setMname("Robert");
    	name.setLname("Doe");
    	
    	employees emp = new employees();
    	emp.setId(3);
    	emp.setEmpname(name);
    	emp.setEmail("John.Doe@foo.com");
    	emp.setDepartment("Engineering");
    	emp.setSalary(90000);
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(employees.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory mySf = config.buildSessionFactory(reg);
    	Session session = mySf.openSession();
    	Transaction Tx = session.beginTransaction();
//    	emp = (employees)session.get(employees.class, 1);
    	session.save(emp);
    	Tx.commit();
    	System.out.println(emp);
    }
}
