package com.example.lab11.hibermanytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.lab11.model.Cart;
import com.example.lab11.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        
        try 
        {
        session.beginTransaction();
        Cart item1=new Cart();
        item1.setName("mobiles");
        
        Cart item2=new Cart();
        item2.setName("electronics");
        
        Product p1=new Product();
        p1.setName(" phone charger");
        
        Product p2=new Product();
        p2.setName("samsung phone");
        
       item1.getItems().add(p1);
       item1.getItems().add(p2);
       item2.getItems().add(p1);
        
        session.save(item1);
        session.save(item2);
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
        }
        finally 
        {
        	session.close();
        	sessionFactory.close();
        }    

    }
}