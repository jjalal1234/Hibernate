package com.Jawwad.relMapHib;

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
        Laptop lapTop = new Laptop();
        lapTop.setLid(1);
        lapTop.setLname("Dell");
        
    	employees emp = new employees();
    	emp.setId(1);
    	emp.setLast_name("Queue");
    	emp.setFirst_name("Susan");
    	emp.setEmail("Susan.Queue@foo.com");
    	emp.setDepartment("Engineering");
    	emp.setSalary(90000);
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(employees.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory mySf = config.buildSessionFactory(reg);
    	Session session = mySf.openSession();
    	Transaction Tx = session.beginTransaction();
    	session.save(lapTop);
    	session.save(emp);    	
    	Tx.commit();
    	System.out.println(emp);
    }
}
