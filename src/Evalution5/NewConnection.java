package Evalution5;

import java.util.Scanner;

public class NewConnection {
    public void details(){
        String name;
        String email;
        String address;
        long aadhaar;
        String simType;
        double initialBalance;
        long random;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name:");
        name = sc.nextLine();
        System.out.println("Enter Email:");
        email = sc.nextLine();
        System.out.println("Enter address:");
        address = sc.nextLine();
        System.out.println("Enter aadhaar:");
        aadhaar = sc.nextLong();
        System.out.println("Enter SimType:");
        simType = sc.nextLine();
        System.out.println("Enter InitialBalance:");
        initialBalance = sc.nextDouble();
        System.out.println("Enter Moblie Number:");
        random = sc.nextLong() % 10000000000l;



    }
}
