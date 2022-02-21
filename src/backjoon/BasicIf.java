package backjoon;

import java.io.*;
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
        if(hour>=24) hour -= 24;
        int minute = duringM % 60;

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(hour + " " + minute);
        output.flush();
        output.close();
    }

    public static void ThreeClock() throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] dices = input.readLine().split(" ");
        int ans = 0;
        int present = 0;

        if(dices[0].equals(dices[1])&&dices[1].equals(dices[2])) ans = 1;
        else if(!dices[0].equals(dices[1])&&!dices[0].equals(dices[2])&&!dices[1].equals(dices[2])) ans = 3;
        else ans = 2;

        switch (ans) {
            case 1:
                present = 10000+1000*Integer.parseInt(dices[0]);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public static void main(String[] args) throws IOException {
//        CheckTwoNum();
//        TestGrade();
//        CheckQuardrant();
//        AlarmClock();
        OvenClock();
    }
}
