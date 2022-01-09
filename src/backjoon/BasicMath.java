package backjoon;

import java.util.Scanner;

public class BasicMath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt(); // 고정비용
        int B = input.nextInt(); // 가변비용
        int C = input.nextInt(); //가격
        int profit = C - B;

        System.out.println(A / profit + 1);
    }
}
