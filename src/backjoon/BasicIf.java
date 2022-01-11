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

    public static void main(String[] args) {
        CheckTwoNum();
    }
}
