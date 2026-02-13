package Classses;

import java.util.Scanner;
public class calculator {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter first number: ");
	double num1=sc.nextDouble();
	System.out.println("enter the second number: ");
	double num2=sc.nextDouble();
	
		System.out.println("choose an operator(+,-,*,/): ");
	
	char op=sc.next().charAt(0);
	switch(op) {
	case '+':
		System.out.println("Result= "+(num1+num2));
		break;
	case '-':
		System.out.println("Result= "+(num1-num2));
		break;
	case '*':
		System.out.println("Result is: "+(num1*num2));
		break;
		case '/': 
			if(num2!=0) {
				System.out.println("result= "+(num1 /num2));
			}else {
				System.out.println("Division not possible");
			}
		
		default :
		System.out.println("Invalid operator");
	}
}
}
