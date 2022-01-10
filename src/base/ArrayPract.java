package base;

import java.util.Arrays;
import java.util.Scanner;

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

    public static void ReserveSeat() { // 좌석예약 시스템
        Scanner input = new Scanner(System.in);
        System.out.print("극장의 좌석수를 입력하세요: ");
        final int SIZE = input.nextInt();
        int seatNum;
        int[] seats = new int[SIZE];

        while (true) {
            for (int i = 0; i < SIZE; i++) {
                if (i < 9) System.out.print("----");
                else System.out.print("-----");
            }
            System.out.print("\n");
            for (int i = 0; i < SIZE; i++) System.out.printf("   %d", i + 1);
            System.out.print("\n");
            for (int i = 0; i < SIZE; i++) {
                if (i < 9) System.out.print("----");
                else System.out.print("-----");
            }
            System.out.print("\n");
            for (int i = 0; i < SIZE; i++) {
                if (i < 9) System.out.print("   " + seats[i]);
                else System.out.print("    " + seats[i]);
            }

            System.out.print("\n원하시는 좌석번호를 입력하세요(종료는 -1): ");
            seatNum = input.nextInt();
            if (seatNum == -1) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (seats[seatNum - 1] == 0) {
                seats[seatNum - 1] = 1;
                System.out.println("예약되었습니다.");
            } else System.out.println("이미 예약된 자리입니다.");

        }
    }

    public static void main(String[] args) {
//        MaxMinCheck();
//        DicePercent();
        ReserveSeat();
    }
}
