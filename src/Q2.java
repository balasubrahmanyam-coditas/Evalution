abstract class Order{
    int id;
    abstract void accept();
    abstract void display();
}
class Purchase extends  Order{
    String customerName="Rams";
    public void accept(){
        customerName = "Rams";
    }
    public void display(){
        System.out.println(customerName);
    }

}
class SalesOrder extends Order{
    String vendorName="Vikas";
    public void accept(){

    }
    public void display(){
        System.out.println(vendorName);
    }
}
public class Q2 {
    public static void main(String[] args) {
        Order order = new SalesOrder();
        order.display();

        Purchase purchase = new Purchase();
        purchase.display();



    }
}
/*
Vikas
Rams

Process finished with exit code 0

 */