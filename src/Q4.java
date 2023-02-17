import java.util.Scanner;

class Vehicle{
    public void members(){
        String company = "LLP solutions";
        int price = 233333;
        System.out.println("NAME OF COMPANY:"+company+"PRICE OF IT:"+price);
    }

}
class LightMotorVehicle extends Vehicle{
    public void members(){
        double mileage = 25.5;
        System.out.println("MILEAGE OF IT:"+mileage);
    }

}
class HeavyMotorVehicle extends Vehicle{
    public void members(){
        double capacityInTons = 345.23;
        System.out.println("TONS:"+capacityInTons);
    }

}
public class Q4 {
    public static void main(String[] args) {
        HeavyMotorVehicle heavyMotorVehicle = new HeavyMotorVehicle();
        heavyMotorVehicle.members();
        LightMotorVehicle lightMotorVehicle = new LightMotorVehicle();
        lightMotorVehicle.members();
        Scanner sc = new Scanner(System.in);
        System.out.println("CHOOSE YOUR VEHICLE TYPE:");
        System.out.println("1.Light Motor Vehicle");
        System.out.println("2.Heavy Motor Vehicle");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println(lightMotorVehicle);
                break;
            case 2:
                System.out.println(heavyMotorVehicle);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}

/*
TONS:345.23
MILEAGE OF IT:25.5
CHOOSE YOUR VEHICLE TYPE
1.Light Motor Vehicle
2.Heavy Motor Vehicle
Enter your choice:
2
HeavyMotorVehicle@135fbaa4

Process finished with exit code 0

 */
