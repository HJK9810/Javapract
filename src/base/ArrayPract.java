package base;

import java.util.Arrays;

public class ArrayPract {
    public static void MaxMinCheck() {
        int[] ary = new int[]{90, 80, 20, 60, 70};
        Arrays.sort(ary);
        System.out.printf("최솟값은 %d입니다.\n", ary[0]);
        System.out.printf("최댓값은 %d입니다.\n", ary[ary.length - 1]);
    }

    public static void DicePercent() {
        final int SIZE = 6;
        int[] dicecount = new int[SIZE];

        for (int i = 0; i < 10000; i++) { // 주사위를 10000번 던졌을때 각 면이 나온 횟수
            ++dicecount[(int) (Math.random() * SIZE)];
        }
        System.out.println("====================");
        System.out.println(" 면    빈도 ");
        System.out.println("====================");

        for (int i = 0; i < SIZE; i++) {
            System.out.printf(" %d    %d\n", i + 1, dicecount[i]);
        }
    }

    public static void main(String[] args) {
//        MaxMinCheck();
        DicePercent();
    }
}
