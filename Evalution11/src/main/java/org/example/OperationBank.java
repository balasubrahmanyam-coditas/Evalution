package org.example;

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

public class OperationBank {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void createBank(Bank bank) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bank);

        transaction.commit();

        session.close();

    }

    public static void SelectBank() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<Bank> bankList = new ArrayList<Bank>();
        try {
            Query query = session.createQuery("from Bank");
            bankList = query.getResultList();

            Iterator iterator = bankList.listIterator();
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


    public static void UpdateBank() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter bid:");
        int bid = Integer.parseInt(sc.readLine());
        System.out.println("Enter Updated bname)");


        Bank bank = session.get(Bank.class, bid);
        bank.setbName(sc.readLine());

        session.saveOrUpdate(bank);
        transaction.commit();
        session.close();

    }

    public static void DeleteBank() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Enter bid:");
        int bid = Integer.parseInt(sc.readLine());

        Bank bank= session.get(Bank.class, bid);

        session.delete(bank);

        transaction.commit();

        session.close();

    }
}


