package backjoon;

import java.util.Scanner;

public class Main {
    public static int Plus1() {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();

        System.out.println(A + B);
        return 0;
    }

    public static double Divis1() {
        Scanner input = new Scanner(System.in);
        double A = input.nextInt();
        double B = input.nextInt();

        System.out.println(A / B);
        return 0;
    }

    public static int Remain () {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();

        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
        return 0;
    }

    public static int Multi() {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();

        int first = B/100;
        B %= 100;
        int second = B/10;
        B%=10;
        System.out.println(A*B);
        System.out.println(A*second);
        System.out.println(A*first);

        System.out.println(A*first*100+A*second*10+A*B);
        return 0;
    }
    public static void main(String[] args) {

    }
}
