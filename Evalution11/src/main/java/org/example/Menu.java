package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        //User<Accounts>l;

        while (flag) {
            System.out.println("0.Exit");
            System.out.println("1.create");
            System.out.println("2.Update");
            System.out.println("3.Select");
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
                        System.out.println("1.User");
                        System.out.println("2.Account");
                        System.out.println("3.Bank");
                        int choice1 = Integer.parseInt(sc.readLine());
                        switch (choice1) {
                            case 0:
                                flag1 = false;
                                break;
                            case 1:
                                User user = new User();
                                System.out.println("Enter Name of User:");
                                user.setName(sc.readLine());
                                System.out.println("Enter uid");
                                user.setId(Integer.parseInt(sc.readLine()));
                                OperationUser.createUser(user);
                                break;

                            case 2:
                                Accounts accounts = new Accounts();
                                System.out.println("Enter Name of Account:");
                                accounts.setaName(sc.readLine());
                                OperationAccounts.createAccounts(accounts);
                                break;
                            case 3:
                                Bank bank = new Bank();
                                System.out.println("Enter Name of bank:");
                                bank.setbName(sc.readLine());

                                OperationBank.createBank(bank);
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
                        System.out.println("1.User");
                        System.out.println("2.Account");
                        System.out.println("3.Bank");
                        int choice2 = Integer.parseInt(sc.readLine());
                        switch (choice2) {
                            case 0:
                                flag2 = false;
                                break;
                            case 1:
                                OperationUser.SelectUser();
                                break;

                            case 2:
                                OperationAccounts.SelectAccounts();
                                break;
                            case 3:
                                OperationBank.SelectBank();
                                break;
                            default:
                                System.out.println("Invaild Choice!!!");

                        }
                    }
                    break;
                case 3:
                    boolean flag3 = true;
                    while (flag3) {
                        System.out.println("Update");
                        System.out.println("0.Exit");
                        System.out.println("1.User");
                        System.out.println("2.Account");
                        System.out.println("3.Bank");
                        int choice3 = Integer.parseInt(sc.readLine());
                        switch (choice3) {
                            case 0:
                                flag1 = false;
                                break;
                            case 1:
                                OperationUser.UpdateUser();
                                break;

                            case 2:
                                OperationAccounts.UpdateAccounts();
                                break;
                            case 3:
                                OperationBank.UpdateBank();
                                break;
                            default:
                                System.out.println("Invaild Choice!!!");

                        }
                    }
                    break;
                case 4:
                    boolean flag4 = true;
                    while (flag4) {
                        System.out.println("Delete");
                        System.out.println("0.Exit");
                        System.out.println("1.User");
                        System.out.println("2.Account");
                        System.out.println("3.Bank");
                        int choice4 = Integer.parseInt(sc.readLine());
                        switch (choice4) {
                            case 0:
                                flag4 = false;
                                break;
                            case 1:
                                OperationUser.DeleteUser();
                                break;

                            case 2:
                                OperationAccounts.DeleteAccounts();
                                break;
                            case 3:
                                OperationBank.DeleteBank();
                                break;
                            default:
                                System.out.println("Invaild Choice!!!");

                        }
                    }
                    break;
                case 5:
                    boolean flag5 = true;
                    while (flag5) {
                        System.out.println("0.Exit");
                        System.out.println("1.Account Date");
                        System.out.println("2.UpdatedBalance");
                        System.out.println("3.Query3");

                        int choice6 = Integer.parseInt(sc.readLine());
                        switch (choice6) {
                            case 0:
                                flag1 = false;
                                break;
                            case 1:
                                HibernateQuery.Query1();
                                break;
                            case 2:
                                HibernateQuery.Query2();
                                break;
                            case 3:
                                HibernateQuery.Query3();
                                break;
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