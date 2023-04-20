package com;


import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CrudOperations {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


    public static void createUser(Product student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();

        session.close();

    }


    public static void SelectUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<Product> productList = new ArrayList<Product>();
        try {
            Query query = session.createQuery("from Product");
            productList = query.getResultList();

            Iterator iterator = productList.listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public static void UpdateUser() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter id:");
        int id = Integer.parseInt(sc.readLine());
        System.out.println("Enter Updated(name,age,address)");


        Product product = session.get(Product.class, id);
        product.setName(sc.readLine());
        product.setPrice(Integer.parseInt(sc.readLine()));
        product.setQuantity(sc.read());

        session.saveOrUpdate(product);
        transaction.commit();
        session.close();

    }

    public static void DeleteUser() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Enter ID:");
        int id = Integer.parseInt(sc.readLine());

        Product studentInfo = session.get(Product.class, id);

        session.delete(studentInfo);

        transaction.commit();

        session.close();

    }
}
