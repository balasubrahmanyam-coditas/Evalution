package Evalution5;

import java.util.Scanner;

public class SimCompany extends  Exception{
    public void prepaid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Mobile Number");
        long num = sc.nextLong();
        int choice = 100;
        while(choice!=0){
            System.out.println("Press 0. To Check Balance");
            System.out.println("Press 1. To Recharge");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    //Check balance
                    break;
                case 2:
                    //Recharge
                    break;
            }
        }
    }
}
