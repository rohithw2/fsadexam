package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Supplier.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Supplier s = new Supplier();
        s.setName("ABC Supplier");
        s.setDescription("Electronics Supplier");
        s.setDate(new Date());
        s.setStatus("Active");

        session.save(s);

        System.out.println("Supplier inserted successfully");

        tx.commit();

        session.close();
        sf.close();
    }
}