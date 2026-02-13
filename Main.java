package paymt;


import java.util.Scanner;
interface Payment {
	void pay(double amount);
	}
class Phonepe implements Payment {
	@Override
	public void pay(double amount) {
		System.out.println("Withdraw amount: "+amount);
		System.out.println("payment successfull using Phonepe");
	}
}
class Gpay implements Payment {
	@Override
	public void pay(double amount) {
		System.out.println("withdraw amount: "+amount);
		System.out.println("Payment Successfull using Gpay");
	}
	
}
class Paytm implements Payment {
	@Override
	public void pay(double amount) {
		System.out.println("Withdraw amount: "+amount);
		System.out.println("Payment Successfull using Paytm");
	}
}
public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Withdraw amount: ");
		double amount=sc.nextDouble();
		System.out.println("....PAYMENT METHOD....");
		System.out.println("1.Phonepe");
		System.out.println("2. Gpay");
		System.out.println("3. Paytm");
		
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		
		Payment p;
		switch(choice) {
		case 1: 
			p=new Phonepe();
			p.pay(amount);;
			break;
		case 2:
			p= new Gpay();
			p.pay(amount);;
			break;
		case 3:
			p=new Paytm();
			p.pay(amount);;
			break;
		default :
			System.out.println("Invalid choice");
			
		}
		
	}

}
