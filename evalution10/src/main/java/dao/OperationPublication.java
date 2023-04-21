package dao;

import org.example.Publication;
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

public class OperationPublication {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void createPublication(Publication publication) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(publication);

        transaction.commit();

        session.close();

    }

    public static void SelectPublication() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<Publication> publicationList = new ArrayList<Publication>();
        try {
            Query query = session.createQuery("from Publication");
            publicationList = query.getResultList();

            Iterator iterator = publicationList.listIterator();
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


    public static void UpdatePublication() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter pid:");
        int pid = Integer.parseInt(sc.readLine());
        System.out.println("Enter Updated(pname)");


        Publication publication = session.get(Publication.class, pid);
        publication.setpName(sc.readLine());

        session.saveOrUpdate(publication);
        transaction.commit();
        session.close();

    }

    public static void DeletePublication() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Enter pid:");
        int pid = Integer.parseInt(sc.readLine());

        Publication publication= session.get(Publication.class, pid);

        session.delete(publication);

        transaction.commit();

        session.close();

    }
}


