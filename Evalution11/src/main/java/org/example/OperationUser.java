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

public class OperationUser {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void createUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);

        transaction.commit();

        session.close();

    }


    public static void SelectUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<User> userList = new ArrayList<User>();
        try {
            Query query = session.createQuery("from user");
            userList = query.getResultList();

            Iterator iterator = userList.listIterator();
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

        System.out.println("Enter uid:");
        int id = Integer.parseInt(sc.readLine());
        System.out.println("Enter updated UserName");


        User user = session.get(User.class, id);
        user.setName(sc.readLine());

        session.saveOrUpdate(user);
        transaction.commit();
        session.close();

    }

    public static void DeleteUser() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Enter uid:");
        int aid = Integer.parseInt(sc.readLine());

        User user = session.get(User.class, aid);

        session.delete(user);

        transaction.commit();

        session.close();

    }


}

