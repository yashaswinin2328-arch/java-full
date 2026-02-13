package Classses;
class employee{
	String Name;
	int age;
	int Ph_no;
 void display()
 {
	 System.out.println("Name: "+Name);
	 System.out.println("Age: "+age);
	 System.out.println("Phone no: "+Ph_no);
	 }
}
public class employedetails {

	public static void main(String[] args) {
		employee emp = new employee();
		emp.Name="Yashu";
		emp.age=28;
		emp.Ph_no= 984565748;
		emp.Name="Sushma";
		emp.age=28;
		emp.Ph_no=265684;
		
		emp.display();
	}
}