package Evalution5;

public class RechargeAmountTooLowException extends Exception {
    RechargeAmountTooLowException(){
        System.out.println("Recharge amount must be greaterthan 0");
    }
}
