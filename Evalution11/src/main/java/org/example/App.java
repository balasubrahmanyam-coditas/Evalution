package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration().configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();


//        Accounts accounts = session.get(Accounts.class,aid);
//        User user = new User();
//        user.setName("Kishor");
//        user.setAccountsList(accounts);
//        user.getId().add(user);
//        session.save(accounts);

        Bank bank = new Bank();
        bank.setbId(1);
        bank.setbName("SBI");

        Bank bank1 = new Bank();
        bank1.setbId(2);
        bank1.setbName("PNB");

        User user = new User();
        user.setName("Vinod");
        user.setBank(bank);

        User user1 = new User();
        user1.setName("Manu");
        user1.setBank(bank1);

//        accounts = new Accounts();
        Accounts accounts1 = new Accounts();
        accounts1.setaName("savings");
        accounts1.setAid(1);

        Accounts accounts2 = new Accounts();
        accounts2.setaName("current");
        accounts2.setAid(1);

        List<Accounts> list = new ArrayList<Accounts>();
        list.add(accounts1);
        list.add(accounts2);

        user.setAccountsList(list);

//        accounts.setBooks(book);
//        accounts1.setBooks();

        Transaction tx = session.beginTransaction();
        session.save(bank);
        session.save(bank1);
        session.save(user);
        session.save(user1);
        session.save(accounts1);
        session.save(accounts2);
        tx.commit();
        session.close();
        factory.close();

        System.out.println( "Hello World!" );
    }
}
