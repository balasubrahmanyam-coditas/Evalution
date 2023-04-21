package dao;

import org.example.Author;
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

public class OperationAuthor {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void createAuthor(Author author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);

        transaction.commit();

        session.close();

    }


    public static void SelectAuthor() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<Author> authorList = new ArrayList<Author>();
        try {
            Query query = session.createQuery("from Author");
            authorList = query.getResultList();

            Iterator iterator = authorList.listIterator();
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


    public static void UpdateAuthor() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter aid:");
        int id = Integer.parseInt(sc.readLine());
        System.out.println("Enter Updated(aname)");


        Author author = session.get(Author.class, id);
        author.setaName(sc.readLine());

        session.saveOrUpdate(author);
        transaction.commit();
        session.close();

    }

    public static void DeleteAuthor() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Enter aid:");
        int aid = Integer.parseInt(sc.readLine());

        Author author = session.get(Author.class, aid);

        session.delete(author);

        transaction.commit();

        session.close();

    }


}

