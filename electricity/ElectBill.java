import java.util.Scanner;

class ElectricityBill {
    private int units;
    private double bill;
    public ElectricityBill(int units) {
        this.units = units;
    }
    public void calculateBill() {
        if (units<=100) {
            bill = units*5;
        } 
        else if (units<=200) {
            bill = (100*5)+(units-100)*7;
        } 
        else {
            bill = (100*5)+(100*7)+(units-200)*10;
        }
    }
    public double getBill() {
        return bill;
    }

 
    public void displayBill() {
        System.out.println("Units Consumed = " + units);
        System.out.println("Electricity Bill = Rs. " + bill);
    }
}

public class ElectBill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        ElectricityBill eb = new ElectricityBill(units);

        eb.calculateBill();
        eb.displayBill();

        sc.close();
    }
}
