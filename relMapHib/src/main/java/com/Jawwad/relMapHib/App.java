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
        lapTop.setLname("HP");
        
    	employees emp = new employees();
    	emp.setId(1);
    	emp.setLast_name("Doe");
    	emp.setFirst_name("John");
    	emp.setEmail("John.Doe@foo.com");
    	emp.setDepartment("Engineering");
    	emp.setSalary(85000);
    	emp.getLapTop().add(lapTop);
    	lapTop.getEmp().add(emp);
    	
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
