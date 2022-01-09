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

    public static void ContMonthDays() {
        Scanner input = new Scanner(System.in);
        System.out.print("일수를 알고 싶은 월을 입력하시오:");
        int month = input.nextInt();
        int day = 0;

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                day = 28;
                break;
            default:
                day = 31;
                break;
        }

        System.out.println("월의 날수는 " + day);
    }

    public static void GCD() { // 최대공약수 찾기
        Scanner input = new Scanner(System.in);
        System.out.print("두개의 정수를 입력하시오(큰수, 작은수): ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        while (num2 != 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }

        System.out.println("최대 공약수는 " + num1);
    }

    public static void RandomSum() {
        Scanner input = new Scanner(System.in);
        System.out.print("난수의 개수: ");
        int count = input.nextInt();
        int sum = 0;
        Random generator = new Random();

        for (int i = 0; i < count; i++) {
            int number = generator.nextInt(100);
            sum += number;
        }

        System.out.printf("난수 %d개의 합은 %d", count, sum);
    }

    public static void findNum() {
        Scanner input = new Scanner(System.in);
        int number = (int) (Math.random() * (100)) + 1;
        int count = 0;
        int guess;

        do {
            System.out.print("정답을 추측하여 보십시오: ");
            guess = input.nextInt();
            count++;
            if (guess < number) System.out.println("제시한 정수가 낮습니다.");
            else if (guess > number) System.out.println("제시한 정수가 높습니다.");
        } while (guess != number);

        System.out.println("축하합니다. 시도횟수 = " + count);
    }

    public static void main(String[] args) {
//        CheckGrade();
//        PrintHello();
//        ContMonthDays();
//        GCD();
//        RandomSum();
        findNum();
    }
}
