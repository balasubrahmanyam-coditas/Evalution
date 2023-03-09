package Evalution5;
import java.util.Scanner;
public class Recharge {
    public void getRecharge(){
        Scanner sc = new Scanner(System.in);
            System.out.println("Name of user: ");
            System.out.println("Balance of user: ");
            System.out.println("Validity of user: ");

            System.out.println("Enter the amount to Recharge ");
            int amount = sc.nextInt();

            if (amount > 0) {
                System.out.println("Amount entered for recharge is: " + amount);
            } else {
                try {
                    throw new RechargeAmountTooLowException();
                } catch (RechargeAmountTooLowException e) {
            }
        }
    }

}
