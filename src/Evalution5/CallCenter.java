package Evalution5;

import java.util.Scanner;

public class CallCenter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome");
        int choice = 100;

        SimCompany simCompany = new SimCompany();
        NewConnection newConnection = new NewConnection();

        while(choice!=0){
            System.out.println("Press 0.Exit");
            System.out.println("Press 1.Prepaid User");
            System.out.println("Press 2.New Connection");
            System.out.println("Press 3.View All Users");
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    System.out.println("Thank You ");
                    break;
                case 1:
                    //Prepaid
                    simCompany.prepaid();
                    break;
                case 2:
                    //New Connection
                    newConnection.details();
                    break;
                case 3:
                    //View all users
                    break;
                default:
                    System.out.println("Pressed Invaild Choice");
            }
        }
    }
}
