import java.util.Scanner;
public class StudentDetails {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] names = new String[3];
        int[][] marks=new int[3][3];
        int[] total= new int[5];
        double[] percentage=new double[5];

        for(int i=0;i<3;i++)
        {
            System.out.print("\n Enter Student "+(i+1)+ " Name: ");
            names[i]=sc.nextLine();
            total[i]=0;
            for(int j=0; j<3; j++)
            {
                System.out.println("enter marks for Subjects " + (j+1) + ": ");
                marks[i][j] = sc.nextInt();
                total[i] = total[i] + marks[i][j];
            }
            percentage[i] = total/3.0;
            sc.nextLine();
    

        }
            System.out.println("\n---------------------------------------------------------------------------");
            System.out.println("Name\tSub1\tSub2\tSub3\tTotal\tPercentage(%)\t\t Grade");
            System.out.println("-----------------------------------------------------------------------------");

            for(int i=0;i<5;i++)
            {
                String grade;
                if (percentage[i] >= 90 && percentage[i] <= 100)
                    grade = "A";
                else if (percentage[i] >= 75 && percentage[i] < 90)
                    grade = "B";
                else if (percentage[i] >= 60 && percentage[i] < 75)
                    grade = "C";
                else if (percentage[i] >= 35 && percentage[i] < 60)
                    grade = "D";
                else
                    grade = "F";

                System.out.println(names[i] + "\t" + marks[1][0] + "\t" +marks[i][1]+ "\t" +marks[i][2] +"\t"+total[i] +"\t"+
                    percentage[i]+"\t"+grade);
                
            }
        
    }
}

