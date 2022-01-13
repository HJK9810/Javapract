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

    public static void AryMinNum() { // X보다 작은수
        Scanner input = new Scanner(System.in);
        int SIZE = input.nextInt();
        int X = input.nextInt();
        int[] ary = new int[SIZE];

        for(int i=0;i<SIZE;i++) {
            ary[i] = input.nextInt();
        }

        for (int num : ary) {
            if (num < X) System.out.println(num);
        }
    }

    public static void main(String[] args) {
//        NineXNine();
        Plus7();
    }
}
