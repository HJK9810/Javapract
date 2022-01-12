package backjoon;

import java.util.Scanner;

public class BasicFor {
    public static void NineXNine() { //구구단 출력
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + num * i);
        }
    }
    public static void main(String[] args) {

    }
}
