package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

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

        if (grade >= 90) System.out.println("A");
        else if (grade >= 80) System.out.println("B");
        else if (grade >= 70) System.out.println("C");
        else if (grade >= 60) System.out.println("D");
        else System.out.println("F");
    }

    public static void CheckQuardrant() {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();

        if (x > 0) {
            if (y > 0) System.out.println(1);
            else System.out.println(4);
        } else {
            if (y > 0) System.out.println(2);
            else System.out.println(3);
        }
    }

    public static void AlarmClock() {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int M = input.nextInt();
        int hour = H, minute = M - 45;

        if (minute < 0) {
            hour -= 1;
            minute += 60;

            if (hour < 0) hour = 23;
        }

        System.out.println(hour + " " + minute);
    }

    public static void OvenClock() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] nowTimes = input.readLine().split(" ");
        int duringTime = Integer.parseInt(input.readLine());

        int duringM = Integer.parseInt(nowTimes[1]) + duringTime;
        int hour = duringM / 60 + Integer.parseInt(nowTimes[0]);
        if (hour >= 24) hour -= 24;
        int minute = duringM % 60;

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(hour + " " + minute);
        output.flush();
        output.close();
    }

    public static void ThreeClock() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] dices = input.readLine().split(" ");
        int[] dice = new int[dices.length];
        for (int i = 0; i < dices.length; i++) {
            dice[i] = Integer.parseInt(dices[i]);
        }
        Arrays.sort(dice);
        int ans = 0;
        int present = 0;

        if (dice[0] == dice[1] && dice[1] == dice[2]) ans = 1;
        else if (dice[0] == dice[1] && dice[1] != dice[2]) {
            present = dice[0];
            ans = 2;
        } else if (dice[0] != dice[1] && dice[1] == dice[2]) {
            present = dice[1];
            ans = 2;
        } else ans = 3;

        switch (ans) {
            case 1:
                present = 10000 + 1000 * dice[0];
                break;
            case 2:
                present = present * 100 + 1000;
                break;
            case 3:
                present = dice[2] * 100;
                break;
            default:
                break;
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(present);
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
//        CheckTwoNum();
//        TestGrade();
//        CheckQuardrant();
//        AlarmClock();
//        OvenClock();
        ThreeClock();
    }
}
