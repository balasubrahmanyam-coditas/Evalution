package dao;

import org.example.Author;
import org.example.Book;
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
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();



        Query<Book>query = session.createQuery("SELECT b FROM Book b JOIN b.publisher p WHERE p.publisherName = 'Nirali' AND b.bookPrice >= 600");
//        Query query = session.createQuery(hql1);
//        List<Publication> results = query.getResultList();

        query.setParameter("name", "Nirali");
        query.setParameter("price", 500);

        List<Book> books = query.getResultList();

        for (Book book : books) {
            System.out.println("Book Name:"+book.getbName()+"  "+"Publication:"+book.getPublication().getpName()+"  "+"Price: "+book.getbPrice());
        }
//        session.save(hql1);

        transaction.commit();
        session.close();


    }
    public static void Query3() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


//        String hql = "SELECT b FROM Book b JOIN b.author a WHERE a.authorName LIKE 'A%i'";
//        NativeQuery<Author> query;
//        query = session.createNativeQuery(hql, Author.class);

        Query<Book> query = session.createQuery("SELECT b FROM Book b JOIN b.author a WHERE a.name LIKE 'a%i'", Book.class);
        List<Book> books = query.getResultList();

        for (Book book : books) {
            System.out.println(book.getbName()+"  "+ book.getAuthor().getaName());
        }

        transaction.commit();
        session.close();



        session.close();

    }
}
