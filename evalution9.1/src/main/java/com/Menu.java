package com;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        List<Product> l;
        while(flag){
            System.out.println("0.Exit");
            System.out.println("1.Create");
            System.out.println("2.Retrieve");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            int choice = Integer.parseInt(sc.readLine());

            switch (choice){
                case 0:
                    flag = false;
                    break;
                case 1:
                    Product product = new Product();
                    System.out.println("Enter Name of Product:");
                    product.setName(sc.readLine());
                    System.out.println("Enter price:");
                    product.setPrice(Integer.parseInt(sc.readLine()));
                    System.out.println("Enter quantity:");
                    product.setQuantity(sc.read());
                    CrudOperations.createUser(new Product());
                    break;

                case 2:
                    CrudOperations.SelectUser();
                    break;
                case 3:
                    CrudOperations.UpdateUser();
                    break;
                case 4:
                    CrudOperations.DeleteUser();
                    break;
                default:
                    System.out.println("Invaild Choice!!!");
            }
        }
    }
}
