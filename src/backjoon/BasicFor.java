package backjoon;

import java.io.*;
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

        for (int i = 0; i < SIZE; i++) {
            ary[i] = input.nextInt();
        }

        for (int num : ary) {
            if (num < X) System.out.println(num);
        }
    }

    public static void Plus8() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = Integer.parseInt(input.readLine());
        String[] printStr = new String[SIZE];

        for (int i = 0; i < SIZE; i++) {
            String s = input.readLine();
            String[] nums = s.split(" ");
            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
            printStr[i] = "Case #" + (i + 1) + ": " + nums[0] + " + " + nums[1] + " = " + sum;
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.println(printStr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
//        NineXNine();
//        Plus7();
        Plus8();
    }
}
