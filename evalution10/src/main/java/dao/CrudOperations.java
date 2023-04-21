package dao;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.example.Book;
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
    public static void createBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(book);

        transaction.commit();

        session.close();

    }


    public static void SelectBook() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List<Book> bookList = new ArrayList<Book>();
        try {
            Query query = session.createQuery("from Book");
            bookList = query.getResultList();

            Iterator iterator = bookList.listIterator();
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


    public static void UpdateBook() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Enter bid:");
        int id = Integer.parseInt(sc.readLine());
        System.out.println("Enter Updated(bname)");


        Book book = session.get(Book.class, id);
        book.setbName(sc.readLine());

        session.saveOrUpdate(book);
        transaction.commit();
        session.close();

    }

    public static void DeleteBook() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("Enter bid:");
        int id = Integer.parseInt(sc.readLine());

        Book book = session.get(Book.class, id);

        session.delete(book);

        transaction.commit();

        session.close();

    }

}
