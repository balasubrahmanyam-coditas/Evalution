package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String... args)
    {
        Configuration configuration = new AnnotationConfiguration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Author author = new Author();
        author.setaId(1);
        author.setaName("Vinod");

        Book book = new Book();
        book.setbId(1);
        book.setbName("HarryPotter");
        book.setbPrice(1000);
        book.setAuthor(author);

        Publication publication = new Publication();
        publication.setPid(1);
        publication.setpName("Nirali");
        LocalDate localDate = LocalDate.of(2021,1,1);
        Date date = Date.valueOf(localDate);
        publication.setpDate(date);

        Book book1 = new Book();
        book1.setbId(2);
        book1.setbName("fast");
        book1.setbPrice(200);
        book1.setAuthor(author);

        Publication publication1 = new Publication();
        publication1.setPid(2);
        publication1.setpName("Bala");
        LocalDate localDate1 = LocalDate.of(2023,3,3);
        Date date1 = Date.valueOf(localDate1);
        publication1.setpDate(date1);

        List<Book> bookSet= new ArrayList<Book>();
        bookSet.add(book);
        bookSet.add(book1);
        author.setBookSet(bookSet);

        book.setPublication(publication);
        book1.setPublication(publication1);

            //System.out.println(author.getaName());


            session.save(book);
            session.save(book1);
            session.save(author);

            session.save(publication);
            session.save(publication1);

            transaction.commit();

            session.close();


    }
}
