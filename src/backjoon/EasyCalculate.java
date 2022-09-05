package backjoon;

import java.io.*;
import java.util.Scanner;

public class EasyCalculate {
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

    public static int Remain() {
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

        int first = B / 100;
        B %= 100;
        int second = B / 10;
        B %= 10;
        System.out.println(A * B);
        System.out.println(A * second);
        System.out.println(A * first);

        System.out.println(A * first * 100 + A * second * 10 + A * B);
        return 0;
    }

    private void PlusfUpgrade() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) {
            int A = input.nextInt();
            int B = input.nextInt();
            sum[i] = A + B;
        }

        for (int j : sum) {
            System.out.println(j);
        }
    }

    private void Chess() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] origin = {1, 1, 2, 2, 2, 8};
        String[] pins = input.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pins.length; i++) {
            int num = origin[i] - Integer.parseInt(pins[i]);
            sb.append(num + " ");
        }

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        output.write(sb.toString());
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        EasyCalculate easyCalculate = new EasyCalculate();

        // 킹, 퀸, 룩, 비숍, 나이트, 폰
        easyCalculate.Chess();
    }
}
