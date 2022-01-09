package base;

import java.util.*;

public class ControlState {
    public static int CheckGrade() {
        Scanner input = new Scanner(System.in);
        System.out.print("성적을 입력하시오: ");
        int gradeNum = input.nextInt();
        char gradeStr;

        if (gradeNum >= 90) gradeStr = 'A';
        else if (gradeNum >= 80) gradeStr = 'B';
        else if (gradeNum >= 70) gradeStr = 'C';
        else if (gradeNum >= 60) gradeStr = 'D';
        else gradeStr = 'F';

        System.out.printf("학점 %c", gradeStr);
        return 0;
    }

    public static int PrintHello() { // 인사말 출력
        Date date = new Date();
        int currentHour = date.getHours();
        System.out.println("현재시간은 " + date);

        if (currentHour < 11) System.out.println("Good morning");
        else if (currentHour < 16) System.out.println("Good afternoon");
        else if (currentHour < 20) System.out.println("Good evening");
        else System.out.println("Good night");

        return 0;
    }

    public static void main(String[] args) {
//        CheckGrade();
        PrintHello();
    }
}
