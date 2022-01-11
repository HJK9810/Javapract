package backjoon;

import java.util.Scanner;

public class BasicIf {
    public static void CheckTwoNum() {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        if (num1 > num2) System.out.println(">");
        else if (num1 < num2) System.out.println("<");
        else System.out.println("==");
    }

    public static void TestGrade() {
        Scanner input = new Scanner(System.in);
        int grade = input.nextInt();

        if(grade>=90) System.out.println("A");
        else if(grade>=80) System.out.println("B");
        else if(grade>=70) System.out.println("C");
        else if(grade>=60) System.out.println("D");
        else System.out.println("F");
    }
    public static void main(String[] args) {
//        CheckTwoNum();
        TestGrade();
    }
}