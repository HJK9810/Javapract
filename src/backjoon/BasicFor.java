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

    public static void Plus7() {
        Scanner input = new Scanner(System.in);
        final int SIZE = input.nextInt();
        int[] nums = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            int num1 = input.nextInt();
            int num2 = input.nextInt();
            nums[i] = num1 + num2;
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.println("Case #" + (i + 1) + ": " + nums[i]);
        }
    }
    public static void main(String[] args) {
//        NineXNine();
        Plus7();
    }
}
