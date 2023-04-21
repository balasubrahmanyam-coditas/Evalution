package dao;

import org.example.Author;
import org.example.Publication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class HibernateQuery {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void Query1() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql="select a.authorName from Author a where ";
        hql = "SELECT a FROM Author a JOIN a.bookList b JOIN b.publisher p WHERE  p.publishedDate >= '2021-01-01'";
        Query query = session.createQuery(hql);
        //LocalDate date1;

        //date1 = of(2021, 01, 01);
        session.save(hql);

        transaction.commit();

        session.close();

    }
    public static void Query2() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        String hql1 = "SELECT b FROM Book b JOIN b.publisher p WHERE p.publisherName = 'Nirali' AND b.bookPrice >= 600";
        Query query = session.createQuery(hql1);
        List<Publication> results = query.getResultList();

        session.save(hql1);

        transaction.commit();

        session.close();

    }
    public static void Query3() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        String hql = "SELECT b FROM Book b JOIN b.author a WHERE a.authorName LIKE 'A%i'";
        NativeQuery<Author> query;
        query = session.createNativeQuery(hql, Author.class);


        session.close();

    }
}
