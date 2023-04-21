package dao;

import org.example.Author;
import org.example.Book;
import org.example.Publication;
import org.hibernate.Hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        List<Book> l;
        while (flag) {
            System.out.println("0.Exit");
            System.out.println("1.Create");
            System.out.println("2.Select");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.HibernateQueries");
            int choice = Integer.parseInt(sc.readLine());

            switch (choice) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    boolean flag1 = true;
                    while (flag1) {
                        System.out.println("Create");
                        System.out.println("0.Exit");
                        System.out.println("1.Book");
                        System.out.println("2.Author");
                        System.out.println("3.Publication");
                        int choice1 = Integer.parseInt(sc.readLine());
                        switch (choice1) {
                            case 0:
                                flag1 = false;
                                break;
                            case 1:
                                Book book = new Book();
                                System.out.println("Enter Name of Book:");
                                book.setbName(sc.readLine());
                                System.out.println("Enter bid");
                                book.setbId(Integer.parseInt(sc.readLine()));
                                System.out.println("Enter price of book:");
                                book.setbPrice(Integer.parseInt(sc.readLine()));


                                CrudOperations.createBook(book);
                                break;

                            case 2:
                                Author author = new Author();
                                System.out.println("Enter Name of Author:");
                                author.setaName(sc.readLine());
                                OperationAuthor.createAuthor(author);
                                break;
                            case 3:
                                Publication publication = new Publication();
                                System.out.println("Enter Name of Publication:");
//                                publication.setPrice(sc.read());
                                publication.setpName(sc.readLine());

                                OperationPublication.createPublication(publication);
                                break;
                            default:
                                System.out.println("Invaild Choice!!!");
                                break;

                        }
                    }
                    break;

                case 2:
                    boolean flag2 = true;
                    while (flag2) {
                        System.out.println("Retrive");
                        System.out.println("0.Exit");
                        System.out.println("1.Book");
                        System.out.println("2.Author");
                        System.out.println("3.Publication");
                        int choice2 = Integer.parseInt(sc.readLine());
                        switch (choice2) {
                            case 0:
                                flag2 = false;
                                break;
                            case 1:
                                CrudOperations.SelectBook();
                                break;

                            case 2:
                                OperationAuthor.SelectAuthor();
                                break;
                            case 3:
                                OperationPublication.SelectPublication();
                                break;
                            default:
                                System.out.println("Invaild Choice!!!");

                        }
                    }
                case 3:
                    boolean flag3 = true;
                    while (flag3) {
                        System.out.println("Update");
                        System.out.println("0.Exit");
                        System.out.println("1.Book");
                        System.out.println("2.Author");
                        System.out.println("3.Publication");
                        int choice3 = Integer.parseInt(sc.readLine());
                        switch (choice3) {
                            case 0:
                                flag1 = false;
                                break;
                            case 1:
                                CrudOperations.UpdateBook();
                                break;

                            case 2:
                                OperationAuthor.UpdateAuthor();
                                break;
                            case 3:
                                OperationPublication.UpdatePublication();
                                break;
                            default:
                                System.out.println("Invaild Choice!!!");

                        }
                    }
                case 4:
                    boolean flag4 = true;
                    while (flag4) {
                        System.out.println("Delete");
                        System.out.println("0.Exit");
                        System.out.println("1.Book");
                        System.out.println("2.Author");
                        System.out.println("3.Publication");
                        System.out.println("4.HibernateQuery");
                        int choice4 = Integer.parseInt(sc.readLine());
                        switch (choice4) {
                            case 0:
                                flag4 = false;
                                break;
                            case 1:
                                CrudOperations.DeleteBook();
                                break;

                            case 2:
                                OperationAuthor.DeleteAuthor();
                                break;
                            case 3:
                                OperationPublication.DeletePublication();
                                break;
                            default:
                                System.out.println("Invaild Choice!!!");

                        }
                    }
                case 5:
                    boolean flag5 = true;
                    while (flag5) {
                        System.out.println("0.Exit");
                        System.out.println("1.Publication date");
                        System.out.println("2.price greaterThan 500");
                        System.out.println("3.Letter Starts with A & i");

                        int choice5 = Integer.parseInt(sc.readLine());
                        switch (choice5) {
                            case 0:
                                flag4 = false;
                                break;
                            case 1:
                                HibernateQuery.Query1();

                                break;
                            case 2:
                                HibernateQuery.Query2();
                                break;
                            case 3:
                                HibernateQuery.Query3();
                            default:
                                System.out.println("Invaild");

                        }
                    }
                default:
                    System.out.println("Invaild");
            }
        }
    }
}