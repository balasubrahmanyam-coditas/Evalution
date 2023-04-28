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

public class OperationAccounts {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void createAccounts(Accounts accounts) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(accounts);

        transaction.commit();

        session.close();

    }

    public static void SelectAccounts() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<Accounts> accountsList = new ArrayList<Accounts>();
        try {
            Query query = session.createQuery("from accounts");
            accountsList = query.getResultList();

            Iterator iterator = accountsList.listIterator();
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


    public static void UpdateAccounts() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter aid:");
        int aid = Integer.parseInt(sc.readLine());
        System.out.println("Enter Updated aname)");


        Accounts accounts = session.get(Accounts.class, aid);
        accounts.setaName(sc.readLine());

        session.saveOrUpdate(accounts);
        transaction.commit();
        session.close();

    }

    public static void DeleteAccounts() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Enter aid:");
        int aid = Integer.parseInt(sc.readLine());

        Accounts accounts= session.get(Accounts.class, aid);

        session.delete(accounts);

        transaction.commit();

        session.close();

    }
}


