package org.example;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class HibernateQuery {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void Query1(){
        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        String hql = "FROM User WHERE accountCreationDate < :date";
        Query query= session1.createQuery(hql);
        query.setParameter("date", LocalDate.of(2023, 1, 1));
        List<User> users = query.list();

        transaction1.commit();
        session1.close();




    }
    public static void Query2(){
        Session session2 = sessionFactory.openSession();
        Transaction transaction1 = session2.beginTransaction();

        String hql = "FROM User WHERE updatedBalance > :balance";
        Query query = session2.createQuery(hql);
        query.setParameter("balance", new BigDecimal("100000"));
        List<User> users = query.list();

        transaction1.commit();
        session2.close();

    }
    public static void Query3(){
//        Session session3 = sessionFactory.openSession();
//        Transaction transaction1 = session3.beginTransaction();
//        String hql = "FROM User WHERE id = :userId";
//        Query query = session3.createQuery(hql);
//        query.setParameter("userId", );
//        User user = (User) query.uniqueResult();
//
//        if (user.getCurrentBalance().compareTo(new BigDecimal("100000")) < 0) {
//            BigDecimal balance = user.getCurrentBalance().subtract(new BigDecimal("250"));
//            int monthsSinceLastMaintenance = user.getMonthsSinceLastMaintenance();
//            if (monthsSinceLastMaintenance > 0) {
//                BigDecimal maintenanceCharge = new BigDecimal("150").multiply(new BigDecimal(monthsSinceLastMaintenance));
//                balance = balance.subtract(maintenanceCharge);
//                System.out.println("Maintenance charges of " + maintenanceCharge + " deducted for " + monthsSinceLastMaintenance + " months");
//            }
//            user.setCurrentBalance(balance);
//            System.out.println("Insufficient Balance");
//        }
    }
}
