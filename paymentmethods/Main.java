package paymt;


import java.util.Scanner;
interface Payment {
	void pay(double amount);
	}
class UPI implements Payment {
	@Override
	public void pay(double amount) {
		System.out.println("Withdraw amount: "+amount);
		System.out.println("payment successfull using UPI");
	}
}
class debitcard implements Payment {
	@Override
	public void pay(double amount) {
		System.out.println("withdraw amount: "+amount);
		System.out.println("Payment Successfull using Debit Card");
	}
	
}
class netbanking implements Payment {
	@Override
	public void pay(double amount) {
		System.out.println("Withdraw amount: "+amount);
		System.out.println("Payment Successfull using Net Banking");
	}
}
public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Withdraw amount: ");
		double amount=sc.nextDouble();
		System.out.println("....PAYMENT METHOD....");
		System.out.println("1. UPI");
		System.out.println("2. Debit Card");
		System.out.println("3. Net Banking");
		
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		
		Payment p;
		switch(choice) {
		case 1: 
			p=new UPI();
			p.pay(amount);;
			break;
		case 2:
			p= new debitcard();
			p.pay(amount);;
			break;
		case 3:
			p=new netbanking();
			p.pay(amount);;
			break;
		default :
			System.out.println("Invalid choice");
			
		}
		
	}

}
